package com.example.cleancode.domain.repository

import com.example.cleancode.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}