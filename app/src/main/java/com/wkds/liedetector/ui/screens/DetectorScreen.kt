package com.wkds.liedetector.ui.screens

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.data.models.KDetectorResultScreen
import com.wkds.liedetector.data.viewmodels.TimerViewModel
import com.wkds.liedetector.ui.fragments.CustomAppBar
import com.wkds.liedetector.ui.fragments.HeartBeatAnimation
import com.wkds.liedetector.ui.fragments.PressableScale

@Composable
fun DetectorScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {


    val context = LocalContext.current
    val timerViewModel: TimerViewModel = viewModel()

    val longPressEcg = stringResource(id = R.string.long_press_ecg)

    var isReadingEcg by remember { mutableStateOf(false) }

    val opacity by animateFloatAsState(
        targetValue = if (isReadingEcg) 1f else 0f,
        animationSpec = tween(durationMillis = 300), label = "EGH Opacity transitionSpec"
    )

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy((-30).dp)
    ) {
        CustomAppBar(text = "Detector", navController = navController)

        Column(verticalArrangement = Arrangement.spacedBy((-10).dp)) {
            Box(modifier = Modifier.padding(top = 10.dp), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "banner"
                )

                Box(
                    modifier = Modifier
                        .offset(y = 30.dp)
                        .alpha(opacity)
                        .requiredSize(240.dp)
                ) {
                    HeartBeatAnimation()
                }
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-20).dp),
                painter = painterResource(id = R.drawable.sub_banner),
                contentDescription = "banner sub"
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-30).dp),
                painter = painterResource(id = R.drawable.banner_button),
                contentDescription = "banner sub"
            )

            PressableScale(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-40).dp),
                onTapDown = {
                    isReadingEcg = true
                    timerViewModel.waitAndExecute(
                        delayMillis = 4000L,
                    ) {
                        isReadingEcg = false
                        timerViewModel.cancel()

                        navController?.navigate(KDetectorResultScreen)
                    }
                },
                onTapUp = {
                    if (isReadingEcg) {
                        Toast.makeText(
                            context,
                            longPressEcg,
                            Toast.LENGTH_SHORT
                        ).show()

                        isReadingEcg = false
                    }
                }) {
                Image(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.fingerprint),
                    contentDescription = "banner sub"
                )
            }
        }
    }
}