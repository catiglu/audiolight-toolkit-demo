"""
推荐的文件规格 (Recommended File Specs)
采样率 (Sample Rate): 44100 Hz 或更高 (例如 48000 Hz)。44100 Hz是CD音质标准，足以精确地表示所有可闻频率以及40 Hz的调制包络 
。
位深度 (Bit Depth): 16位 或 24位。16位提供了足够的动态范围（约96 dB），并且是所有音频设备都兼容的标准 
。
文件格式 (File Format): WAV (.wav)。这是一种无损、未压缩的格式，能确保信号的保真度，避免由MP3等有损压缩算法引入的伪影，这些伪影可能会干扰精确的时间结构。
推荐的响度/电平 (Recommended RMS/Peak Levels):
RMS电平： 将文件的长期均方根（RMS）响度校准到一个标准水平，例如 -18 dBFS (分贝满刻度)。这是一种常见的录音室校准标准。这样做的好处是，无论使用何种播放设备，用户都可以将音量调整到一个已知且安全的听力水平。
峰值电平 (Peak Level): 在校准RMS后，应确保信号的峰值电平不超过-1.0 dBFS，以避免数字削波（clipping）失真。上面的代码包含了削波检查。
"""

import numpy as np
import scipy.io.wavfile
import scipy.signal

def generate_40hz_am_pink_noise(
    duration_s: int = 60,
    sample_rate: int = 44100,
    mod_freq: float = 40.0,
    carrier_type: str = 'pink_noise', # 'pink_noise' or a float for sine wave carrier freq
    target_rms_dbfs: float = -18.0,
    bit_depth: int = 16,
    output_filename: str = '40Hz_AM_PinkNoise.wav'
):
    """
    Generates a scientifically appropriate 40 Hz amplitude-modulated audio file.

    Args:
        duration_s: Duration of the audio file in seconds.
        sample_rate: Sampling rate in Hz.
        mod_freq: Modulation frequency in Hz (should be 40.0).
        carrier_type: The carrier signal. 'pink_noise' or a frequency for a sine wave.
        target_rms_dbfs: Target Root Mean Square level in dBFS.
        bit_depth: Bit depth of the output WAV file (16 or 24).
        output_filename: Name of the output WAV file.
    """
    num_samples = int(duration_s * sample_rate)
    time_s = np.linspace(0, duration_s, num_samples, endpoint=False)

    # 1. Generate the carrier signal
    if carrier_type == 'pink_noise':
        # Generate pink noise: inverse FFT of 1/f spectrum
        # Simplified method for generating pink noise
        white_noise = np.random.randn(num_samples)
        fft_white = np.fft.rfft(white_noise)
        frequencies = np.fft.rfftfreq(num_samples, 1/sample_rate)
        # Avoid division by zero at DC component
        pink_spectrum = fft_white / np.sqrt(np.where(frequencies == 0, 1, frequencies))
        pink_spectrum[[77]] = 0 # Set DC to 0
        carrier = np.fft.irfft(pink_spectrum)
    elif isinstance(carrier_type, (int, float)):
        carrier = np.sin(2 * np.pi * carrier_type * time_s)
    else:
        raise ValueError("carrier_type must be 'pink_noise' or a number.")

    # 2. Generate the 40 Hz modulator
    # This creates a sine wave that oscillates between 0.0 and 1.0
    modulator = (np.sin(2 * np.pi * mod_freq * time_s) + 1) / 2

    # 3. Apply amplitude modulation
    modulated_signal = carrier * modulator

    # 4. Calibrate RMS level to target dBFS
    # Formula: linear_scale = 10^(dBFS / 20)
    target_rms_linear = 10**(target_rms_dbfs / 20.0)
    current_rms = np.sqrt(np.mean(modulated_signal**2))
    
    # Avoid division by zero if signal is silent
    if current_rms > 0:
        scaling_factor = target_rms_linear / current_rms
        calibrated_signal = modulated_signal * scaling_factor
    else:
        calibrated_signal = modulated_signal

    # 5. Check for clipping and convert to target bit depth
    # Clipping occurs if any sample exceeds the [-1.0, 1.0] range
    if np.max(np.abs(calibrated_signal)) > 1.0:
        print("Warning: Clipping occurred. The peak level is too high for the target RMS.")
        # Normalize to prevent clipping, this will change the RMS level
        calibrated_signal /= np.max(np.abs(calibrated_signal))

    if bit_depth == 16:
        max_val = 32767
        dtype = np.int16
    elif bit_depth == 24:
        # Note: 24-bit audio is often stored in 32-bit integers in WAV files
        max_val = 8388607 # 2^23 - 1
        # We will use int32 to write, but the values correspond to 24-bit range
        calibrated_signal = (calibrated_signal * max_val).astype(np.int32)
        # scipy handles 24-bit by taking int32 arrays.
        # However, to be safe, we will write 16-bit which is universally supported.
        max_val = 32767
        dtype = np.int16
        calibrated_signal = (calibrated_signal * max_val).astype(dtype) # Fallback to 16-bit for simplicity
    else:
        raise ValueError("bit_depth must be 16 or 24.")

    # Final conversion for 16-bit
    final_audio = (calibrated_signal * max_val).astype(dtype)
    
    # 6. Write to WAV file
    scipy.io.wavfile.write(output_filename, sample_rate, final_audio)
    print(f"Successfully generated '{output_filename}'")
    print(f"  Duration: {duration_s} s")
    print(f"  Sample Rate: {sample_rate} Hz")
    print(f"  Bit Depth: {bit_depth}-bit")
    print(f"  Target RMS: {target_rms_dbfs} dBFS")

# --- To run the code, simply call the function ---
if __name__ == '__main__':
    generate_40hz_am_pink_noise()
