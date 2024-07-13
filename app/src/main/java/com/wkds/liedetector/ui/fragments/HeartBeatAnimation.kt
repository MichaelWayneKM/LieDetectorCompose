package com.wkds.liedetector.ui.fragments

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun HeartBeatAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition linear")

    val animatedProgress = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "progress animation"
    )

    Canvas(modifier = modifier.fillMaxSize()) {
        val path = createRealisticHeartbeatPath(size.width, size.height / 2, animatedProgress.value)

        drawPath(
            path = path,
            color = Color.Green,
            style = Stroke(
                width = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}

fun createRealisticHeartbeatPath(width: Float, centerY: Float, progress: Float): Path {
    val path = Path()
    val amplitude = 180f

    val pWaveStart = width * 0.05f
    val pWavePeak = width * 0.075f
    val pWaveEnd = width * 0.1f

    val qWaveStart = width * 0.15f
    val qWaveEnd = width * 0.2f

    val rWavePeak = width * 0.225f

    val sWaveEnd = width * 0.25f

    val tWaveStart = width * 0.35f
    val tWavePeak = width * 0.4f
    val tWaveEnd = width * 0.45f

    val animatedWidth = width * progress

    path.moveTo(0f, centerY)

    if (animatedWidth < pWaveStart) {
        path.lineTo(animatedWidth, centerY)
    } else if (animatedWidth < pWavePeak) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(animatedWidth, centerY - amplitude * 0.1f)
    } else if (animatedWidth < pWaveEnd) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(animatedWidth, centerY)
    } else if (animatedWidth < qWaveStart) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(animatedWidth, centerY)
    } else if (animatedWidth < qWaveEnd) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(animatedWidth, centerY + amplitude * 0.2f)
    } else if (animatedWidth < rWavePeak) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(qWaveEnd, centerY + amplitude * 0.2f)
        path.lineTo(animatedWidth, centerY - amplitude)
    } else if (animatedWidth < sWaveEnd) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(qWaveEnd, centerY + amplitude * 0.2f)
        path.lineTo(rWavePeak, centerY - amplitude)
        path.lineTo(animatedWidth, centerY + amplitude * 0.3f)
    } else if (animatedWidth < tWaveStart) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(qWaveEnd, centerY + amplitude * 0.2f)
        path.lineTo(rWavePeak, centerY - amplitude)
        path.lineTo(sWaveEnd, centerY + amplitude * 0.3f)
        path.lineTo(animatedWidth, centerY)
    } else if (animatedWidth < tWavePeak) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(qWaveEnd, centerY + amplitude * 0.2f)
        path.lineTo(rWavePeak, centerY - amplitude)
        path.lineTo(sWaveEnd, centerY + amplitude * 0.3f)
        path.lineTo(tWaveStart, centerY)
        path.lineTo(animatedWidth, centerY - amplitude * 0.2f)
    } else if (animatedWidth < tWaveEnd) {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(qWaveEnd, centerY + amplitude * 0.2f)
        path.lineTo(rWavePeak, centerY - amplitude)
        path.lineTo(sWaveEnd, centerY + amplitude * 0.3f)
        path.lineTo(tWaveStart, centerY)
        path.lineTo(tWavePeak, centerY - amplitude * 0.2f)
        path.lineTo(animatedWidth, centerY)
    } else {
        path.lineTo(pWaveStart, centerY)
        path.lineTo(pWavePeak, centerY - amplitude * 0.1f)
        path.lineTo(pWaveEnd, centerY)
        path.lineTo(qWaveStart, centerY)
        path.lineTo(qWaveEnd, centerY + amplitude * 0.2f)
        path.lineTo(rWavePeak, centerY - amplitude)
        path.lineTo(sWaveEnd, centerY + amplitude * 0.3f)
        path.lineTo(tWaveStart, centerY)
        path.lineTo(tWavePeak, centerY - amplitude * 0.2f)
        path.lineTo(tWaveEnd, centerY)
        path.lineTo(animatedWidth, centerY)
    }

    return path
}