package com.wkds.liedetector.data.models

import kotlinx.serialization.Serializable

@Serializable
object KSplashScreen

@Serializable
object KHomeScreen

@Serializable
object KHomeStartScreen

@Serializable
object KEnjoySoundScreen

@Serializable
object KDetectorScreen

@Serializable
object KDetectorResultScreen

@Serializable
object KTrimmerScreen

@Serializable
data class KSoundScreen (
    val type: String
)

@Serializable
data class KSoundPlayerScreen (
    val type: String,
    val imageResId: Int,
    val audioResId: Int
)