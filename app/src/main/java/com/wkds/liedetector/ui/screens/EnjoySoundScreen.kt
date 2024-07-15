package com.wkds.liedetector.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.data.models.KSoundScreen
import com.wkds.liedetector.data.models.KTrimmerScreen
import com.wkds.liedetector.ui.fragments.BannerAdView
import com.wkds.liedetector.ui.fragments.CustomAppBar
import com.wkds.liedetector.ui.fragments.PressableScale

@Composable
fun EnjoySoundScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {
    Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 10.dp)) {

        CustomAppBar(text = "Sounds", navController = navController)

        Column(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                (-10).dp
            )
        ) {
            PressableScale(action = { navController?.navigate(KSoundScreen(type = "Animal")) }) {
                Image(
                    modifier = Modifier.padding(bottom = 20.dp),
                    painter = painterResource(id = R.drawable.animal_sound),
                    contentDescription = "animal sound"
                )
            }

            PressableScale(action = { navController?.navigate(KSoundScreen(type = "Baby")) }) {
                Image(
                    modifier = Modifier.padding(bottom = 20.dp),
                    painter = painterResource(id = R.drawable.baby_sound),
                    contentDescription = "baby sound"
                )
            }

            PressableScale(action = { navController?.navigate(KSoundScreen(type = "Gun")) }) {
                Image(
                    modifier = Modifier.padding(bottom = 20.dp),
                    painter = painterResource(id = R.drawable.gun_sound),
                    contentDescription = "gun sound"
                )
            }

            PressableScale(action = { navController?.navigate(KTrimmerScreen) }) {
                Image(
                    modifier = Modifier.padding(bottom = 20.dp),
                    painter = painterResource(id = R.drawable.trimmer_sound),
                    contentDescription = "trimmer sound"
                )
            }
        }

        BannerAdView(modifier = Modifier.padding(top = 100.dp))
    }
}

@Preview
@Composable
fun EnjoySoundPreview() {
    EnjoySoundScreen()
}