package com.audiolight.toolkitdemo

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder

class WavAudioTrackPlayer(private val context: Context) {
    private var track: AudioTrack? = null

    fun playFromAssets(assetName: String) {
        stop()
        val wav = readWavFromAssets(assetName)
        val minSize = AudioTrack.getMinBufferSize(
            wav.sampleRate,
            wav.channelConfig,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val bufferSize = maxOf(minSize, wav.pcm.size)
        track = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            .setAudioFormat(
                AudioFormat.Builder()
                    .setSampleRate(wav.sampleRate)
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .setChannelMask(wav.channelConfig)
                    .build()
            )
            .setBufferSizeInBytes(bufferSize)
            .setTransferMode(AudioTrack.MODE_STATIC)
            .build()

        track?.setLoopPoints(0, wav.totalFrames, -1)
        track?.write(wav.pcm, 0, wav.pcm.size)
        track?.play()
    }

    fun setVolume01(volume: Float) {
        val safe = volume.coerceIn(0f, 1f)
        track?.setVolume(safe)
    }

    fun stop() {
        track?.stop()
        track?.release()
        track = null
    }

    private fun readWavFromAssets(assetName: String): WavData {
        context.assets.open(assetName).use { input ->
            val bytes = input.readBytes()
            if (bytes.size < 44) throw IOException("Invalid WAV size")

            val bb = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
            val riff = String(bytes, 0, 4)
            val wave = String(bytes, 8, 4)
            if (riff != "RIFF" || wave != "WAVE") throw IOException("Not WAV RIFF")

            var offset = 12
            var sampleRate = 44100
            var channels = 1
            var bitsPerSample = 16
            var dataOffset = -1
            var dataSize = -1

            while (offset + 8 <= bytes.size) {
                val chunkId = String(bytes, offset, 4)
                val chunkSize = bb.getInt(offset + 4)
                val chunkDataStart = offset + 8

                if (chunkId == "fmt " && chunkSize >= 16) {
                    val fmt = ByteBuffer.wrap(bytes, chunkDataStart, chunkSize).order(ByteOrder.LITTLE_ENDIAN)
                    val audioFormat = fmt.short.toInt()
                    channels = fmt.short.toInt()
                    sampleRate = fmt.int
                    fmt.int // byte rate
                    fmt.short // block align
                    bitsPerSample = fmt.short.toInt()
                    if (audioFormat != 1) throw IOException("Only PCM WAV supported")
                } else if (chunkId == "data") {
                    dataOffset = chunkDataStart
                    dataSize = chunkSize
                    break
                }

                offset = chunkDataStart + chunkSize
            }

            if (dataOffset < 0 || dataSize <= 0) throw IOException("WAV data chunk not found")
            if (bitsPerSample != 16) throw IOException("Only 16-bit WAV supported")

            val pcm = bytes.copyOfRange(dataOffset, dataOffset + dataSize)
            val channelConfig = if (channels == 1) {
                AudioFormat.CHANNEL_OUT_MONO
            } else {
                AudioFormat.CHANNEL_OUT_STEREO
            }
            val frameSize = channels * 2
            val totalFrames = pcm.size / frameSize

            return WavData(
                sampleRate = sampleRate,
                channelConfig = channelConfig,
                totalFrames = totalFrames,
                pcm = pcm
            )
        }
    }
}

private data class WavData(
    val sampleRate: Int,
    val channelConfig: Int,
    val totalFrames: Int,
    val pcm: ByteArray
)

