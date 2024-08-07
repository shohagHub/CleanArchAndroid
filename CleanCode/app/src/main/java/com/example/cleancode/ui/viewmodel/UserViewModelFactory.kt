package com.example.cleancode.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleancode.domain.usecase.GetUsersUseCase

class UserViewModelFactory(private val getUsersUseCase: GetUsersUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(getUsersUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
