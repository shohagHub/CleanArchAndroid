package com.example.cleancode.data.repository

import com.example.cleancode.data.datasource.UserRemoteDataSourceImpl
import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository

class UserRepositoryImpl(private val remoteDataSourceImpl: UserRemoteDataSourceImpl) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return remoteDataSourceImpl.fetchUsers()
    }

}