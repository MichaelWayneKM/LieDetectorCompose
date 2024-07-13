package com.wkds.liedetector.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wkds.liedetector.R


@Composable
fun FingerprintImage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        // Base Image
        Image(
            modifier = modifier
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.fingerprint_home),
            contentDescription = "fingerprint image"
        )
    }
}

@Preview
@Composable
fun FingerprintImagePreview(modifier: Modifier = Modifier) {
    FingerprintImage(modifier = modifier)
}