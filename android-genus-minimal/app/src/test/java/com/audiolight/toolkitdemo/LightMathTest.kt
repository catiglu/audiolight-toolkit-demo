package com.audiolight.toolkitdemo

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LightMathTest {

    @Test
    fun sineAtQuarterCycleIsPeak() {
        val value = LightMath.sine01(
            timeSec = 1.0 / (4.0 * 40.0),
            base = 0.5,
            amplitude = 0.5,
            freqHz = 40.0
        )
        assertEquals(1.0, value, 1e-6)
    }

    @Test
    fun sineValueAlwaysClampedToRange() {
        val samples = listOf(0.0, 0.001, 0.003, 0.007, 0.011)
        for (t in samples) {
            val value = LightMath.sine01(t, base = 0.5, amplitude = 0.7, freqHz = 40.0)
            assertTrue(value in 0.0..1.0)
        }
    }
}

