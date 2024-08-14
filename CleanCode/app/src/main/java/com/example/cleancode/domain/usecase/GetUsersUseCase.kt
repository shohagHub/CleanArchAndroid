package com.example.cleancode.domain.usecase

import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun execute(): List<User> {
        return userRepository.getUsers()
    }
}