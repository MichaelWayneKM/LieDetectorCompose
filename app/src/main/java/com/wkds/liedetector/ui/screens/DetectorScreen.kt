package com.wkds.liedetector.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.ui.fragments.CustomAppBar
import com.wkds.liedetector.ui.fragments.HeartBeatAnimation
import com.wkds.liedetector.ui.fragments.PressableScale

@Composable
fun DetectorScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {
    Column(modifier = modifier) {
        CustomAppBar(text = "Detector")

        Column {
            Box(modifier = Modifier.padding(top = 10.dp)) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "banner"
                )

                HeartBeatAnimation()
            }

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.sub_banner),
                contentDescription = "banner sub"
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-20).dp),
                painter = painterResource(id = R.drawable.banner_button),
                contentDescription = "banner sub"
            )

            PressableScale(action = { /*TODO*/ }) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.fingerprint),
                    contentDescription = "banner sub"
                )
            }
        }
    }
}