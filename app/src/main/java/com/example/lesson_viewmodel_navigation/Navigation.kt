package com.example.lesson_viewmodel_navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(innerPadding: PaddingValues) {
    // NavController - системный класс для
    // управления перемещениями между экранами
    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()

    // NavHost - хост, определяющий экраны,
    // по которым можно будет перемещаться
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = "MainScreen"
    ) {
        // Перечисление экранов, route указывает название экрана
        composable(
            "MainScreen",
            // Пример анимации перехода между экранами
            enterTransition = {
                slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start)
            }
        ) {
            MainScreen(
                navController = navController,
                mainViewModel = mainViewModel,
                onSetCount = mainViewModel::setCount
            )
        }

        composable(
            "SecondScreen",
            enterTransition = {
                slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up)
            }
        ) {
            SecondScreen(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
}











