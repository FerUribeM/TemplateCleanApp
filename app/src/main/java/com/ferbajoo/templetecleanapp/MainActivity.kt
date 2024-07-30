package com.ferbajoo.templetecleanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.ferbajoo.templetecleanapp.presentation.components.MainBottomNavigation
import com.ferbajoo.templetecleanapp.presentation.navigation.MainNavigation
import com.ferbajoo.templetecleanapp.presentation.theme.TemplateCleanAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            TemplateCleanAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        MainBottomNavigation(navController)
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        MainNavigation(navController = navController)
                    }
                }
            }
        }
    }

}