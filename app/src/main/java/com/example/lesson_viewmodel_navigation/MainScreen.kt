package com.example.lesson_viewmodel_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
// Вариант инициализации ViewModel в функции
    mainViewModel: MainViewModel = viewModel(),
    // Инициализация другой функции как объекта
    onSetCount: () -> Unit,
    navController: NavHostController
) {
    // Механизм rememberSaveable позволяет сохранить значение переменной после
    // поворота экрана
    val count = rememberSaveable { mutableIntStateOf(0) }

    // Чтение состояния из viewModel
    val viewModelCount = mainViewModel.count.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            // Перемещение на другой экран
            navController.navigate("SecondScreen") {
                // Очистка всех экранов из стека для выхода из приложения,
                // а не возврата к экранам
                popUpTo(0) { inclusive = true }
            }
        }) {
            Text("Переход на 2 экран")
        }

        Text("Example with innerPadding")

        Text("Example with innerPadding ${count.intValue}")

        Button(onClick = { count.intValue++ }) {
            Text("На кнопку нажали ${count.intValue} раз")
        }

        Text("Изменение состояния кнопки через ViewModel")

        Button(onClick = { onSetCount() }) {
            Text("На кнопку нажали ${viewModelCount.value} раз")
        }
    }
}