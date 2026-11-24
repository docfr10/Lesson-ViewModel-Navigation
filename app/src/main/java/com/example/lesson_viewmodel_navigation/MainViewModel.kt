package com.example.lesson_viewmodel_navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// Наследуем ViewModel() для того, чтобы иметь доступ к
// ее жизненному циклу и сохранять значения вне зависимости от состояния экрана
class MainViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun setCount() {
        _count.value++
    }
}