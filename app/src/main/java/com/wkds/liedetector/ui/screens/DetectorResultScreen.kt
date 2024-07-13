package com.wkds.liedetector.ui.screens

import android.os.CountDownTimer
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
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.ui.fragments.CustomAppBar
import com.wkds.liedetector.ui.fragments.HeartBeatAnimation
import com.wkds.liedetector.ui.fragments.PressableScale
import com.wkds.liedetector.utils.CancellableTimer

@Composable
fun DetectorResultScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy((-30).dp)
    ) {
        CustomAppBar(text = "Detector")

        Column(verticalArrangement = Arrangement.spacedBy((-10).dp)) {
            Box(modifier = Modifier.padding(top = 10.dp), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "banner"
                )

                Text(text = "TRUE")
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
                contentDescription = "banner button"
            )

        }
    }
}