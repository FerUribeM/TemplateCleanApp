package com.ferbajoo.templetecleanapp.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ferbajoo.templetecleanapp.R
import com.ferbajoo.templetecleanapp.presentation.navigation.getRoute

data class BottomItems(
    val title: String,
    @DrawableRes val icon: Int
)

val items = listOf(
    BottomItems("Home", R.drawable.ic_home),
    BottomItems("Discover", R.drawable.world_globe_line_icon),
    BottomItems("Saved", R.drawable.ic_saved),
    BottomItems("Profile", R.drawable.ic_person_outline)
)

@Composable
fun MainBottomNavigation(navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onBackground,
        tonalElevation = 6.dp,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            val isSelected = currentRoute?.contains(it.title) == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(it.title.getRoute()) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, icon = {
                    if (isSelected) {
                        Row(
                            modifier = Modifier
                                .height(35.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painterResource(id = it.icon),
                                contentDescription = it.title,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = it.title,
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall,
                                modifier = Modifier.padding(horizontal = 2.dp)
                            )
                        }
                    } else {
                        Icon(
                            painterResource(id = it.icon),
                            contentDescription = it.title,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = Color.Gray
                )
            )
        }
    }
}