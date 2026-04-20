import numpy as np
from scipy.io import wavfile

# 参数设置（参考GENUS研究规范）
sample_rate = 44100      # 采样率 44100 Hz
duration_s = 60          # 时长 60 秒
pulse_freq = 40          # 40 Hz 脉冲频率
carrier_freq = 440       # 440 Hz 载波（可听范围内的基频）
duty_cycle = 0.5         # 占空比 50%（开/关各12.5 ms）

t = np.linspace(0, duration_s, int(sample_rate * duration_s), endpoint=False)

# 方法A：振幅调制（AM-modulated），推荐用于单扬声器播放
# 40 Hz包络 × 440 Hz载波
envelope = 0.5 * (1 + np.sign(np.sin(2 * np.pi * pulse_freq * t)))  # 方波包络
signal = envelope * np.sin(2 * np.pi * carrier_freq * t)

# 归一化至 -3 dBFS（RMS约为0.5，避免削波）
signal = signal / np.max(np.abs(signal)) * 0.5

# 转为 16-bit PCM
signal_int16 = (signal * 32767).astype(np.int16)
wavfile.write("40hz_GENUS_stimulus.wav", sample_rate, signal_int16)
print("生成完成：40hz_GENUS_stimulus.wav")