package com.example.ibustartup.backend.repositories

import androidx.lifecycle.LiveData
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    suspend fun upsertUser(user: User) {
        userDao.upsertUser(user)
    }

    suspend fun insertUser(user: User) {
        userDao.upsertUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    val allUsers: Flow<List<User>> = userDao.getAllUsers()
}