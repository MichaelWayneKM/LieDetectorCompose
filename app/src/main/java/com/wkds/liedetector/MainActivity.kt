package com.wkds.liedetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wkds.liedetector.data.models.KDetectorResultScreen
import com.wkds.liedetector.data.models.KDetectorScreen
import com.wkds.liedetector.data.models.KEnjoySoundScreen
import com.wkds.liedetector.data.models.KHomeScreen
import com.wkds.liedetector.data.models.KHomeStartScreen
import com.wkds.liedetector.ui.screens.DetectorResultScreen
import com.wkds.liedetector.ui.screens.DetectorScreen
import com.wkds.liedetector.ui.screens.EnjoySoundScreen
import com.wkds.liedetector.ui.screens.HomeScreen
import com.wkds.liedetector.ui.screens.HomeStartScreen
import com.wkds.liedetector.ui.theme.LiedetectorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiedetectorTheme {

                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = Color.White,
                    containerColor = Color.Black
                ) { innerPadding ->

                    NavHost(navController = navController, startDestination = KDetectorResultScreen) {
                        composable<KHomeScreen> {
                            HomeScreen(navController = navController, modifier = Modifier.padding(innerPadding))
                        }

                        composable<KHomeStartScreen> {
                            HomeStartScreen(navController = navController, modifier = Modifier.padding(innerPadding))
                        }

                        composable<KEnjoySoundScreen> {
                            EnjoySoundScreen(navController = navController, modifier = Modifier.padding(innerPadding))
                        }

                        composable<KDetectorScreen> {
                            DetectorScreen(navController = navController, modifier = Modifier.padding(innerPadding))
                        }

                        composable<KDetectorResultScreen> {
                            DetectorResultScreen(navController = navController, modifier = Modifier.padding(innerPadding))
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun ApplicationRouting() {

}