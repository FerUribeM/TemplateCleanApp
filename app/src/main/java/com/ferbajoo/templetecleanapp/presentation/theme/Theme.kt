package com.ferbajoo.templetecleanapp.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PurpleBackground,
    onPrimary = Color.White,
    onPrimaryContainer = Color(0x407362E6),
    secondary = PurpleGrey80,
    onSecondary = Color.White,
    tertiary = Pink80,
    onTertiary = Color.White,
    background = PurpleBackground,
    onBackground = SecondaryBackgroundDark,
    primaryContainer = PurpleDark,
    surfaceTint = SecondaryBackgroundLight
)

private val LightColorScheme = lightColorScheme(
    primary = Pink40,
    onPrimary = Color.White,
    onPrimaryContainer = Color(0xFFE2E2E4),
    secondary = PurpleGrey40,
    onSecondary = Color(0xFF5FAEE5),
    tertiary = Pink40,
    onTertiary = Color.Black,
    background = Color.White,
    onBackground = SecondaryBackgroundLight,
    primaryContainer = Blue,
    surfaceTint = IconsColor
)

@Composable
fun TemplateCleanAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}