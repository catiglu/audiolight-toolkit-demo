package com.audiolight.toolkitdemo

import java.util.Locale

object SessionCsv {
    const val HEADER =
        "timestamp_iso,mode,duration_sec,brightness,volume,symptom_score,interrupted,stop_reason"

    fun row(
        timestampIso: String,
        mode: String,
        durationSec: Long,
        brightness: Double,
        volume: Double,
        symptomScore: Int,
        interrupted: Boolean,
        stopReason: String
    ): String {
        val safeReason = stopReason.replace(",", ";")
        return String.format(
            Locale.US,
            "%s,%s,%d,%.3f,%.3f,%d,%s,%s",
            timestampIso,
            mode,
            durationSec,
            brightness,
            volume,
            symptomScore,
            interrupted.toString(),
            safeReason
        )
    }
}

