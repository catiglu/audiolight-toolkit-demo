package com.audiolight.toolkitdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.SystemClock
import android.util.AttributeSet
import android.view.Choreographer
import android.view.View
import kotlin.math.roundToInt

class LightModulatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs), Choreographer.FrameCallback {

    private val paint = Paint().apply { style = Paint.Style.FILL }
    private var running = false
    private var startUptimeMs = 0L

    var base = 0.5
    var amplitude = 0.5
    var freqHz = 40.0

    fun start() {
        if (running) return
        running = true
        startUptimeMs = SystemClock.uptimeMillis()
        Choreographer.getInstance().postFrameCallback(this)
    }

    fun stop() {
        running = false
        Choreographer.getInstance().removeFrameCallback(this)
        paint.color = Color.BLACK
        invalidate()
    }

    override fun doFrame(frameTimeNanos: Long) {
        if (!running) return
        invalidate()
        Choreographer.getInstance().postFrameCallback(this)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val t = (SystemClock.uptimeMillis() - startUptimeMs) / 1000.0
        val v = LightMath.sine01(t, base, amplitude, freqHz)
        val gray = (v * 255.0).roundToInt().coerceIn(0, 255)
        paint.color = Color.rgb(gray, gray, gray)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}

