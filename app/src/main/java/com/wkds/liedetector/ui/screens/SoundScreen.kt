package com.wkds.liedetector.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wkds.liedetector.data.models.ConcreteSoundData
import com.wkds.liedetector.data.models.GridItem
import com.wkds.liedetector.data.models.KSoundPlayerScreen
import com.wkds.liedetector.data.models.SoundData
import com.wkds.liedetector.ui.fragments.BannerAdView
import com.wkds.liedetector.ui.fragments.CustomAppBar
import com.wkds.liedetector.ui.fragments.PressableScale


@Composable
fun SoundScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    type: String = "Animal"
) {
    val soundData: SoundData = ConcreteSoundData()
    val gridItems = soundData.getSoundData(type)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        CustomAppBar(text = "$type Sounds", navController = navController)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            items(gridItems.size) { index ->
                val item = gridItems[index]

                GridItem(
                    type = type,
                    item = item,
                    navController = navController
                )
            }
        }

        BannerAdView(modifier = Modifier.padding(top = 80.dp))
    }
}

@Composable
fun GridItem(type: String, item: GridItem, navController: NavHostController? = null) {
    PressableScale(
        action = {
            navController?.navigate(
                KSoundPlayerScreen(
                    type = type,
                    imageResId = item.imageResId,
                    audioResId = item.audioResId
                )
            )
        },
        modifier = Modifier
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(item.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SoundScreen()
}