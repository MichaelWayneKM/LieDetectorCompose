package com.wkds.liedetector.ui.screens

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.data.models.KEnjoySoundScreen
import com.wkds.liedetector.ui.fragments.PressableScale
import com.wkds.liedetector.ui.fragments.RoundButton
import com.wkds.liedetector.ui.theme.LiedetectorTheme

@Composable
fun HomeStartScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopComposable(
            modifier = Modifier
        )

        PressableScale(action = { /*TODO*/ }) {
            Image(
                modifier = Modifier.padding(bottom = 20.dp),
                painter = painterResource(id = R.drawable.start_scanner),
                contentDescription = stringResource(
                    id = R.string.start_scanner
                )
            )
        }

        PressableScale(action = { navController?.navigate(KEnjoySoundScreen) }) {
            Image(
                modifier = Modifier.padding(bottom = 20.dp),
                painter = painterResource(id = R.drawable.enjoy_sound),
                contentDescription = stringResource(
                    id = R.string.play_sounds
                )
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = Color.BLACK.toLong())
@Composable
fun HomeStartScreenPreview() {
    LiedetectorTheme {
        HomeStartScreen()
    }
}