package com.example.cleancode.data.datasource

import com.example.cleancode.domain.model.User

class UserRemoteDataSourceImpl : UserRemoteDataSource {
    override suspend fun fetchUsers(): List<User> {
        return listOf(User(1, "User One"),
            User(2, "User Two"),
            User(3, "User Three"))
    }

}