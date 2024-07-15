package com.wkds.liedetector.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wkds.liedetector.data.models.GridItem
import com.wkds.liedetector.ui.fragments.BannerAdView
import com.wkds.liedetector.ui.fragments.CustomAppBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun SoundPlayerScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    data: GridItem
) {
    val context = LocalContext.current

    val isPlaying = remember { mutableStateOf(true) }
    val currentPosition = remember { mutableFloatStateOf(0f) }

    val mediaPlayer = remember {
        MediaPlayer.create(context, data.audioResId).apply {
            isLooping = false
            setOnCompletionListener {
                // Reset the state when audio finishes
                isPlaying.value = false
                currentPosition.floatValue = 0f
            }
        }
    }

    val duration = mediaPlayer.duration.toFloat()

    // Update the progress bar
    LaunchedEffect(mediaPlayer) {
        mediaPlayer.start()
        while (isActive) {
            if (mediaPlayer.isPlaying) {
                currentPosition.floatValue = mediaPlayer.currentPosition.toFloat()
            }
            delay(100)
        }
    }

    DisposableEffect(mediaPlayer) {
        onDispose {
            mediaPlayer.release()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomAppBar(modifier = Modifier.fillMaxWidth(), navController = navController)

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = data.imageResId),
            contentDescription = "media thumbnail",
            modifier = Modifier
                .size(290.dp)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clip(CircleShape)
                .background(color = Color.White)
                .size(100.dp)
                .clickable {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.pause()
                        isPlaying.value = false
                    } else {
                        mediaPlayer.start()
                        isPlaying.value = true
                    }
                },
        ) {
            Icon(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .size(50.dp),
                imageVector = if (isPlaying.value) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                contentDescription = if (isPlaying.value) "Pause" else "Play",
                tint = Color.Black
            )
        }

        Slider(
            value = currentPosition.floatValue,
            onValueChange = {
                mediaPlayer.seekTo(it.toInt())
                currentPosition.floatValue = it
            },
            valueRange = 0f..duration,
            modifier = Modifier
                .fillMaxWidth()
                .progressSemantics(),
            colors = SliderDefaults.colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Green
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        BannerAdView(modifier = Modifier.padding(top = 40.dp))
    }
}
