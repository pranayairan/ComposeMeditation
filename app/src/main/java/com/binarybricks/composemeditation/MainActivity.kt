package com.binarybricks.composemeditation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.binarybricks.composemeditation.ui.HomeScreen
import com.binarybricks.composemeditation.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                HomeScreen()
            }
        }
    }
}