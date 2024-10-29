package com.example.thelifeofcounselor.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    background = Gray800,
    surface = Gray700,
    outline = Gray600,
    onPrimary = Gray50,
    onBackground = Gray50,
    onSurface = Gray400,
    onSurfaceVariant = Gray200
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    background = Gray50,
    surface = Gray100,
    outline = Gray200,
    onPrimary = Gray50,
    onBackground = Gray900,
    onSurface = Gray300,
    onSurfaceVariant = Gray500
)

@Composable
fun TheLifeOfCounselorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme
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
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}