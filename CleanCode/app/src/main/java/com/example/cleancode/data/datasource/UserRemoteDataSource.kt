package com.example.cleancode.data.datasource

import com.example.cleancode.domain.model.User

interface UserRemoteDataSource {
    suspend fun fetchUsers(): List<User>
}