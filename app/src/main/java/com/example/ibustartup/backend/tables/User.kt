package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
