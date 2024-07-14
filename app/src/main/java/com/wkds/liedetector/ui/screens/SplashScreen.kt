package com.wkds.liedetector.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.data.models.KSplashScreen
import com.wkds.liedetector.utils.CancellableTimer
import okhttp3.internal.wait

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {

    val cancellableTimer = CancellableTimer()

    LaunchedEffect(Unit) {
        cancellableTimer.waitAndExecute(3000L) {
//            navController?.navigate(KSplashScreen)
        }
    }

    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.fingerprint_splash),
            contentDescription = "fingerprint slash"
        )


    }
}