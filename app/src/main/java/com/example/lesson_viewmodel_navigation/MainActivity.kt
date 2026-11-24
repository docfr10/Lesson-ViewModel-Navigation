package com.example.lesson_viewmodel_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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
                    // Вариант инициализации ViewModel в виде объекта
                    val mainViewModel: MainViewModel = viewModel()

                    MainScreen(
                        innerPadding = innerPadding,
                        mainViewModel = mainViewModel,
                        onSetCount = mainViewModel::setCount
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    // Вариант инициализации ViewModel в функции
    mainViewModel: MainViewModel = viewModel(),
    // Инициализация другой функции как объекта
    onSetCount: () -> Unit
) {
    // Механизм rememberSaveable позволяет сохранить значение переменной после
    // поворота экрана
    val count = rememberSaveable { mutableIntStateOf(0) }

    // Чтение состояния из viewModel
    val viewModelCount = mainViewModel.count.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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