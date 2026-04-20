package com.audiolight.toolkitdemo

import org.junit.Assert.assertTrue
import org.junit.Test

class CsvRowFormatTest {

    @Test
    fun csvRowContainsCoreFieldsInOrder() {
        val row = SessionCsv.row(
            timestampIso = "2026-04-20T12:00:00",
            mode = "active_40hz",
            durationSec = 120,
            brightness = 0.7,
            volume = 0.5,
            symptomScore = 2,
            interrupted = false,
            stopReason = ""
        )

        assertTrue(row.startsWith("2026-04-20T12:00:00,active_40hz,120,0.700,0.500,2,false,"))
    }
}

