"""
推荐参数
采样率：44.1 kHz
位深：16-bit 或 32-bit float
峰值：< -3 dBFS
RMS：-20 ~ -14 dBFS
格式：WAV（无损）
"""
import numpy as np
from scipy.io.wavfile import write

fs = 44100
duration = 300  # 秒
t = np.linspace(0, duration, int(fs*duration), endpoint=False)

carrier = 440  # Hz
mod_freq = 40  # Hz

signal = (0.5 * (1 + np.sin(2*np.pi*mod_freq*t))) * np.sin(2*np.pi*carrier*t)

write("40hz_am.wav", fs, signal.astype(np.float32))