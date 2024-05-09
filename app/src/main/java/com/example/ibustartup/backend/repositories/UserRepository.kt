package com.example.ibustartup.backend.repositories

import androidx.lifecycle.LiveData
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun upsertUser(user: User)

    suspend fun insertUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun deleteUser(user: User)

    fun getAllUsers(): Flow<List<User>>

    fun getUserByID(id: Int): Flow<User>
}