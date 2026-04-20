package com.audiolight.toolkitdemo

import android.content.ContentValues
import android.content.Context
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CsvLogger(private val context: Context) {

    private val appCsvFile: File by lazy {
        File(context.getExternalFilesDir(null), "genus_sessions.csv")
    }

    fun append(row: String) {
        ensureHeader()
        appCsvFile.appendText("$row\n")
    }

    fun exportToDownloads(): String {
        ensureHeader()
        val displayName = "genus_sessions_${timestampForFile()}.csv"
        val values = ContentValues().apply {
            put(MediaStore.Downloads.DISPLAY_NAME, displayName)
            put(MediaStore.Downloads.MIME_TYPE, "text/csv")
            put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }

        val resolver = context.contentResolver
        val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
            ?: throw IOException("Failed to create export file")

        resolver.openOutputStream(uri)?.use { out ->
            appCsvFile.inputStream().use { input -> input.copyTo(out) }
        } ?: throw IOException("Failed to open export stream")

        return displayName
    }

    private fun ensureHeader() {
        if (!appCsvFile.exists()) {
            appCsvFile.parentFile?.mkdirs()
            appCsvFile.writeText("${SessionCsv.HEADER}\n")
        }
    }

    private fun timestampForFile(): String {
        return DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now())
    }
}

