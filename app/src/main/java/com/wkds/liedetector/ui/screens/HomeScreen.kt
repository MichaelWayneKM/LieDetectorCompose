package com.wkds.liedetector.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wkds.liedetector.R
import com.wkds.liedetector.ui.fragments.FingerprintImage
import com.wkds.liedetector.ui.fragments.RoundButton
import com.wkds.liedetector.ui.theme.LiedetectorTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeLeadingTitle(
            modifier = Modifier
        )

        FingerprintImage()

        Image(
            painter = painterResource(id = R.drawable.lets_start_btn),
            contentDescription = stringResource(
                id = R.string.start_txt
            )
        )

        Row {
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
fun HomeLeadingTitle(modifier: Modifier = Modifier) {
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
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    LiedetectorTheme {
        Column {
            HomeLeadingTitle()
        }
    }
}