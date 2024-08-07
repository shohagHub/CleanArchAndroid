package com.example.cleancode.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel(private val getUserUseCase: GetUsersUseCase) : ViewModel(){
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun fetchUser() {
        viewModelScope.launch {
            val userList = getUserUseCase.execute()
            _users.postValue(userList)
        }
    }
}