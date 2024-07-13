package com.wkds.liedetector.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wkds.liedetector.R


@Composable
fun FingerprintImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.fingerprint),
        contentDescription = "fingerprint image"
    )
}

@Preview
@Composable
fun FingerprintImagePreview(modifier: Modifier = Modifier) {
    FingerprintImage()
}