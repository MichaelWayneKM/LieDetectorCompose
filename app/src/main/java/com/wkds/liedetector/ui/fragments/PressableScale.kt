package com.wkds.liedetector.ui.fragments

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun PressableScale(
    modifier: Modifier = Modifier,
    scaleFactor: Float = 0.95f,
    animationDuration: Int = 100,
    action: () -> Unit = {},
    onTapDown: () -> Unit = { Log.d("long_pressed", "Pressable pressed")},
    onTapUp: () -> Unit = { Log.d("long_pressed_release", "Pressable released")},
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) scaleFactor else 1f,
        animationSpec = tween(durationMillis = animationDuration), label = "scale"
    )

    val opacity by animateFloatAsState(
        targetValue = if (isPressed) 0.8f else 1f,
        animationSpec = tween(durationMillis = animationDuration), label = "opacity"
    )

    Box(
        modifier = modifier
            .scale(scale)
            .alpha(opacity)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        onTapDown()
                        tryAwaitRelease()
                        action()
                        onTapUp()
                        isPressed = false
                    },
                )
            }
    ) {
        content()
    }
}