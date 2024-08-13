package com.example.cleancode.data.datasource.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleancode.domain.model.User

@Entity(tableName = "users")
data class UserEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0, // Auto-incrementing primary key
    val name: String) {
    fun toDomainDomel() = User(id, name)
}
