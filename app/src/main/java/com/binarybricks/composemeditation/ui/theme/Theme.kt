package com.binarybricks.composemeditation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MeditationUIYouTubeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(color = DeepBlue)

    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}