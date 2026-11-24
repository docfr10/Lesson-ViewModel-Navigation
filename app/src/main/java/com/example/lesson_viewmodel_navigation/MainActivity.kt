package com.example.lesson_viewmodel_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.lesson_viewmodel_navigation.ui.theme.LessonViewModelNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LessonViewModelNavigationTheme {
                // Контейнер, являющийся "основой" для других компонентов
                // позволяет автоматически учитывать отступы от границ экрана любых
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(innerPadding = innerPadding)
                }
            }
        }
    }
}