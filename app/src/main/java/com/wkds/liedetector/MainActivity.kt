package com.wkds.liedetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wkds.liedetector.data.models.DetectorNavigation
import com.wkds.liedetector.ui.screens.HomeScreen
import com.wkds.liedetector.ui.theme.LiedetectorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiedetectorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = DetectorNavigation.Home.name) {
                        composable(DetectorNavigation.Home.name) {
                            HomeScreen(modifier = Modifier.padding(innerPadding))
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