import numpy as np
from scipy.io.wavfile import write

fs = 44100
duration = 60
t = np.linspace(0, duration, int(fs * duration), endpoint=False)

# 1. 方波包络（最接近GENUS click train）
envelope = 0.5 * (1 + np.sign(np.sin(2 * np.pi * 40 * t)))

# 2. 粉噪声载波（来自方案C）
white = np.random.randn(len(t))
fft_w = np.fft.rfft(white)
freqs = np.fft.rfftfreq(len(t), 1/fs)
pink = np.fft.irfft(fft_w / np.sqrt(np.where(freqs == 0, 1, freqs)))
pink = pink[:len(t)]

# 3. 调制
signal = envelope * pink

# 4. RMS校准至-18 dBFS（来自方案C）
target_rms = 10 ** (-18 / 20)
current_rms = np.sqrt(np.mean(signal**2))
signal = signal * (target_rms / current_rms)

# 5. 削波保护
if np.max(np.abs(signal)) > 1.0:
    signal /= np.max(np.abs(signal))

# 6. 写出16-bit WAV
write("40hz_GENUS_optimal.wav", fs, (signal * 32767).astype(np.int16))