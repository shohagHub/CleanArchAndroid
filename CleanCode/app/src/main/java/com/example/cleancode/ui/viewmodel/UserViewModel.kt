package com.example.cleancode.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.usecase.GetUsersUseCase
import com.example.cleancode.domain.usecase.InsertUserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUsersUseCase,
    private val insertUserUseCases: InsertUserUseCases) : ViewModel(){
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun fetchUser() {
        viewModelScope.launch {
            val userList = getUserUseCase.execute()
            _users.postValue(userList)
        }
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            insertUserUseCases.insertUser(user)
            fetchUser()
        }
    }
}