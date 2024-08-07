package com.example.cleancode.domain.usecase

import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository

class GetUsersUseCase (private val userRepository: UserRepository) {
    suspend fun execute(): List<User> {
        return userRepository.getUsers()
    }
}