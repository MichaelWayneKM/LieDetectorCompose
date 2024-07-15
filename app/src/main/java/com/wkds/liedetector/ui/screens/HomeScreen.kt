package com.wkds.liedetector.ui.screens

import android.graphics.Color
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wkds.liedetector.R
import com.wkds.liedetector.data.models.KHomeStartScreen
import com.wkds.liedetector.ui.fragments.FingerprintImage
import com.wkds.liedetector.ui.fragments.PressableScale
import com.wkds.liedetector.ui.fragments.RoundButton
import com.wkds.liedetector.ui.theme.LiedetectorTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController? = null) {

    val context = LocalContext.current
    var showExitPrompt by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    BackHandler {
        if (showExitPrompt) {
            (context as ComponentActivity).finish() // Exit the app
        } else {
            Toast.makeText(context, "Press back once more to exit app.", Toast.LENGTH_SHORT).show()
            showExitPrompt = true
            coroutineScope.launch {
                delay(2000L) // Reset the exit prompt after 2 seconds
                showExitPrompt = false
            }
        }
    }

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

        PressableScale(action = { navController?.navigate(KHomeStartScreen) }) {
            Image(
                modifier = Modifier.padding(bottom = 20.dp),
                painter = painterResource(id = R.drawable.lets_start_btn),
                contentDescription = stringResource(
                    id = R.string.start_txt
                )
            )
        }

        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RoundButton(
                imageResource = R.drawable.privacy,
                description = stringResource(id = R.string.privacy),
                action = { /* TODO */ }
            )

            RoundButton(
                imageResource = R.drawable.share,
                description = stringResource(id = R.string.privacy),
                action = { /* TODO */ }
            )

            RoundButton(
                imageResource = R.drawable.rate_us,
                description = stringResource(id = R.string.privacy),
                action = { /* TODO */ }
            )
        }
    }
}

@Composable
fun HomeTopComposable(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(id = R.string.app_name).uppercase(),
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            stringResource(id = R.string.app_name_home_subtext).lowercase(),
            fontSize = 20.sp,
            fontWeight = FontWeight.W400
        )
        FingerprintImage(modifier = Modifier.padding(bottom = 40.dp))
    }
}

@Preview(showBackground = true, backgroundColor = Color.BLACK.toLong())
@Composable
fun HomeScreenPreview() {
    LiedetectorTheme {
        HomeScreen()
    }
}