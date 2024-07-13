package com.wkds.liedetector.ui.fragments

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoundButton(
    modifier: Modifier = Modifier,
    @DrawableRes imageResource: Int,
    description: String,
    action: () -> Unit
) {
    PressableScale(action = action) {
        Image(
            modifier = Modifier.requiredSize(100.dp),
            painter = painterResource(id = imageResource),
            contentDescription = description
        )
    }
}