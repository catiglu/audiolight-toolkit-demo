package com.audiolight.toolkitdemo

import android.os.Bundle
import android.os.SystemClock
import android.view.WindowManager
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var lightView: LightModulatorView
    private lateinit var statusText: TextView
    private lateinit var brightnessSeek: SeekBar
    private lateinit var volumeSeek: SeekBar
    private lateinit var player: WavAudioTrackPlayer
    private lateinit var csvLogger: CsvLogger

    private var sessionStartMs: Long = 0L
    private var sessionStartIso: String = ""
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        lightView = findViewById(R.id.lightView)
        statusText = findViewById(R.id.statusText)
        brightnessSeek = findViewById(R.id.brightnessSeek)
        volumeSeek = findViewById(R.id.volumeSeek)
        player = WavAudioTrackPlayer(this)
        csvLogger = CsvLogger(this)

        val startButton: Button = findViewById(R.id.startButton)
        val stopButton: Button = findViewById(R.id.stopButton)
        val exportButton: Button = findViewById(R.id.exportButton)

        brightnessSeek.setOnSeekBarChangeListener(simpleSeek { progress ->
            val normalized = progress / 100.0
            lightView.base = normalized * 0.6 + 0.2
            lightView.amplitude = normalized * 0.4
        })

        volumeSeek.setOnSeekBarChangeListener(simpleSeek { progress ->
            player.setVolume01(progress / 100f)
        })

        startButton.setOnClickListener { startSession() }
        stopButton.setOnClickListener { stopSession(interrupted = false, stopReason = "") }
        exportButton.setOnClickListener { exportCsv() }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (running) {
            stopSession(interrupted = true, stopReason = "activity_destroyed")
        } else {
            player.stop()
        }
    }

    private fun startSession() {
        if (running) return
        sessionStartMs = SystemClock.elapsedRealtime()
        sessionStartIso = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now())

        try {
            player.playFromAssets("40hz_GENUS_optimal.wav")
        } catch (e: IOException) {
            Toast.makeText(
                this,
                "assets 缺少 40hz_GENUS_optimal.wav，请先拷贝文件",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        player.setVolume01(volumeSeek.progress / 100f)
        lightView.start()
        statusText.setText(R.string.status_running)
        running = true
    }

    private fun stopSession(interrupted: Boolean, stopReason: String) {
        if (!running) return
        lightView.stop()
        player.stop()
        statusText.setText(R.string.status_idle)

        val durationSec = ((SystemClock.elapsedRealtime() - sessionStartMs) / 1000L).coerceAtLeast(1L)
        val brightness = brightnessSeek.progress / 100.0
        val volume = volumeSeek.progress / 100.0
        val row = SessionCsv.row(
            timestampIso = sessionStartIso,
            mode = "active_40hz",
            durationSec = durationSec,
            brightness = brightness,
            volume = volume,
            symptomScore = 0,
            interrupted = interrupted,
            stopReason = stopReason
        )
        csvLogger.append(row)
        running = false
    }

    private fun exportCsv() {
        try {
            val name = csvLogger.exportToDownloads()
            Toast.makeText(this, "CSV 已导出到 Downloads/$name", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, "导出失败: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun simpleSeek(onChanged: (Int) -> Unit): SeekBar.OnSeekBarChangeListener {
        return object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                onChanged(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        }
    }
}

