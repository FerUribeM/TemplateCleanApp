package com.ferbajoo.templetecleanapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ferbajoo.templetecleanapp.presentation.discover.Discover
import com.ferbajoo.templetecleanapp.presentation.discover.DiscoverScreen
import com.ferbajoo.templetecleanapp.presentation.news.Home
import com.ferbajoo.templetecleanapp.presentation.news.HomeScreen
import com.ferbajoo.templetecleanapp.presentation.profile.Profile
import com.ferbajoo.templetecleanapp.presentation.profile.ProfileScreen
import com.ferbajoo.templetecleanapp.presentation.saved.Saved
import com.ferbajoo.templetecleanapp.presentation.saved.SavedScreen

fun String.getRoute(): Any {
    return when (this) {
        "Home" -> Home
        "Discover" -> Discover
        "Saved" -> Saved
        "Profile" -> Profile
        else -> Home
    }
}

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Discover> {
            DiscoverScreen()
        }
        composable<Saved> {
            SavedScreen()
        }
        composable<Profile> {
            ProfileScreen()
        }
    }
}