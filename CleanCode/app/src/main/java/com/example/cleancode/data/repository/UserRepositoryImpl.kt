package com.example.cleancode.data.repository

import com.example.cleancode.data.datasource.UserRemoteDataSourceImpl
import com.example.cleancode.data.datasource.room.dao.UserDao
import com.example.cleancode.data.datasource.room.entity.UserEntity
import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userDao.getUsers().map { it.toDomainDomel() }
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(UserEntity(name = user.name))
    }
}