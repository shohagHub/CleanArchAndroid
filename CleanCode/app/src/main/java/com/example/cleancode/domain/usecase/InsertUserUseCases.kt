package com.example.cleancode.domain.usecase

import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository
import javax.inject.Inject

class InsertUserUseCases @Inject constructor(private val userRepository: UserRepository) {
    suspend fun insertUser(user: User) {
        userRepository.insertUser(user)
    }
}