package com.example.cleancode.provider

import android.app.Application
import com.example.cleancode.data.datasource.UserDatabase
import com.example.cleancode.data.datasource.room.dao.UserDao
import com.example.cleancode.data.repository.UserRepositoryImpl
import com.example.cleancode.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideUserDao(app: Application): UserDao {
        val database = UserDatabase.getDatabase(app)
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }
}