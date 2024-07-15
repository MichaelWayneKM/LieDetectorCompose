package com.wkds.liedetector.ui.screens

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.ui.fragments.CustomAppBar


@Composable
fun TrimmerScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {

    val context = LocalContext.current

    // Custom vibration pattern for shaver effect
    val shaverVibrationPattern = longArrayOf(0, 10, 10, 10, 10)

    var isTrimmerOn by rememberSaveable { mutableStateOf(false) }
    val trimmerOnImg = painterResource(id = R.drawable.trimmer_on)
    val trimmerOffImg = painterResource(id = R.drawable.trimmer_off)

    fun startVibration(context: Context) {
        val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java)
        vibrator?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                it.vibrate(VibrationEffect.createWaveform(shaverVibrationPattern, 0))
            } else {
                @Suppress("DEPRECATION")
                it.vibrate(longArrayOf(0, 1000, 1000), 0)
            }
        }
    }


    fun stopVibration(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.cancel()
    }

    LaunchedEffect(key1 = isTrimmerOn) {
        if (isTrimmerOn) {
            startVibration(context)
        } else {
            stopVibration(context)
        }
    }

    DisposableEffect(isTrimmerOn) {
        onDispose {
            stopVibration(context)
        }
    }

    Column(modifier = modifier) {
        CustomAppBar(text = "Trimmer", navController = navController)
        Image(
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(25.dp))
                .fillMaxSize()

                .clickable {
                    isTrimmerOn = !isTrimmerOn
                },
            painter = if (isTrimmerOn) trimmerOnImg else trimmerOffImg,
            contentDescription = "trimmer image"

        )
    }
}