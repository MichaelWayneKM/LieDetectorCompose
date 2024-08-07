package com.wkds.liedetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.wkds.liedetector.data.models.GridItem
import com.wkds.liedetector.data.models.KDetectorResultScreen
import com.wkds.liedetector.data.models.KDetectorScreen
import com.wkds.liedetector.data.models.KEnjoySoundScreen
import com.wkds.liedetector.data.models.KHomeScreen
import com.wkds.liedetector.data.models.KHomeStartScreen
import com.wkds.liedetector.data.models.KSoundPlayerScreen
import com.wkds.liedetector.data.models.KSoundScreen
import com.wkds.liedetector.data.models.KSplashScreen
import com.wkds.liedetector.data.models.KTrimmerScreen
import com.wkds.liedetector.ui.screens.DetectorResultScreen
import com.wkds.liedetector.ui.screens.DetectorScreen
import com.wkds.liedetector.ui.screens.EnjoySoundScreen
import com.wkds.liedetector.ui.screens.HomeScreen
import com.wkds.liedetector.ui.screens.HomeStartScreen
import com.wkds.liedetector.ui.screens.SoundPlayerScreen
import com.wkds.liedetector.ui.screens.SoundScreen
import com.wkds.liedetector.ui.screens.SplashScreen
import com.wkds.liedetector.ui.screens.TrimmerScreen
import com.wkds.liedetector.ui.theme.LiedetectorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder().setTestDeviceIds(listOf("ABCDEF012345")).build()
        )
        enableEdgeToEdge()
        setContent {
            LiedetectorTheme {

                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = Color.White,
                    containerColor = Color.Black
                ) { innerPadding ->

                    NavHost(navController = navController, startDestination = KSplashScreen) {
                        composable<KSplashScreen> {
                            SplashScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KHomeScreen> {
                            HomeScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KHomeStartScreen> {
                            HomeStartScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KEnjoySoundScreen> {
                            EnjoySoundScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KDetectorScreen> {
                            DetectorScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KDetectorResultScreen> {
                            DetectorResultScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KTrimmerScreen> {
                            TrimmerScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable<KSoundScreen> {
                            val args = it.toRoute<KSoundScreen>()

                            SoundScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding),
                                type = args.type
                            )
                        }

                        composable<KSoundPlayerScreen> {
                            val args = it.toRoute<KSoundPlayerScreen>()

                            SoundPlayerScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding),
                                data = GridItem(
                                    imageResId = args.imageResId,
                                    audioResId = args.audioResId
                                )
                            )
                        }
                    }
                }

            }
        }
    }
}