package com.example.cleancode.data.datasource.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cleancode.data.datasource.room.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<UserEntity>
}