package com.example.cleancode.data.datasource


import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.cleancode.data.datasource.room.dao.UserDao
import com.example.cleancode.data.datasource.room.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
