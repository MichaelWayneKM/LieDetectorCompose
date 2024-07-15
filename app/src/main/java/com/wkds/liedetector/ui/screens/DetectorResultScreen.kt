package com.wkds.liedetector.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.ui.fragments.BannerAdView
import com.wkds.liedetector.ui.fragments.CustomAppBar
import kotlin.random.Random

@Composable
fun DetectorResultScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {

    val isTruthyResult by rememberSaveable { mutableStateOf(Random.nextInt(2) > 0) }

    Column {
        Column(
            modifier = modifier
                .weight(2f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy((-10).dp)
        ) {
            CustomAppBar(text = "Detector", navController = navController)

            Column(verticalArrangement = Arrangement.spacedBy((-10).dp)) {
                Box(modifier = Modifier.padding(top = 10.dp), contentAlignment = Alignment.Center) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.banner),
                        contentDescription = "banner"
                    )

                    Text(
                        modifier = Modifier.offset(y = 5.dp),
                        text = if (isTruthyResult) "TRUE" else "FALSE",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-0).dp),
                    painter = painterResource(id = R.drawable.sub_banner),
                    contentDescription = "banner sub"
                )

            }
        }

        BannerAdView(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 60.dp)
                .fillMaxWidth()
        )
    }
}