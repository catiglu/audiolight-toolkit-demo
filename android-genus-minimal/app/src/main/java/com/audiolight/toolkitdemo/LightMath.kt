package com.audiolight.toolkitdemo

import kotlin.math.PI
import kotlin.math.sin

object LightMath {
    fun sine01(
        timeSec: Double,
        base: Double,
        amplitude: Double,
        freqHz: Double
    ): Double {
        val raw = base + amplitude * sin(2.0 * PI * freqHz * timeSec)
        return raw.coerceIn(0.0, 1.0)
    }
}

