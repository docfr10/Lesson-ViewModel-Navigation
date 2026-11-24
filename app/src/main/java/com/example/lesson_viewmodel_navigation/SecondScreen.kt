package com.example.lesson_viewmodel_navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.runtime.collectAsState

@Composable
fun SecondScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { navController.navigate("MainScreen") }) {
            Text("Переход на 1 экран")
        }

        Text("Счетчик с 1 экрана равен ${mainViewModel.count.collectAsState().value}")
    }
}