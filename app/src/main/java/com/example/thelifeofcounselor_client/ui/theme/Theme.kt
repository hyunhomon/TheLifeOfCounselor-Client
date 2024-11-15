package com.example.thelifeofcounselor_client.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    primaryContainer = PrimaryContainer,
    background = White,
    surface = Gray50,
    outline = Gray100,
    onPrimary = Gray50,
    onBackground = Gray900,
    onSurface = Gray300,
    onSurfaceVariant = Gray400
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    primaryContainer = PrimaryContainer,
    background = Gray900,
    surface = Gray800,
    outline = Gray700,
    onPrimary = Gray50,
    onBackground = White,
    onSurface = Gray500,
    onSurfaceVariant = Gray600
)

@Composable
fun TheLifeOfCounselorClientTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (!darkTheme) DarkColorScheme
    else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        val activity = view.context as Activity
        val window = activity.window
        val windowInsetsController = WindowCompat.getInsetsController(window, view)

        SideEffect {
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()

            windowInsetsController.isAppearanceLightStatusBars = !darkTheme
            windowInsetsController.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shape,
        typography = Typography,
        content = content
    )
}