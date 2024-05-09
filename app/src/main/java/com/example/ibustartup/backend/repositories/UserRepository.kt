package com.example.ibustartup.backend.repositories

import androidx.lifecycle.LiveData
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    suspend fun upsertUser(user: User) = userDao.upsertUser(user)

    suspend fun insertUser(user: User) = userDao.insertUser(user)

    suspend fun updateUser(user: User) = userDao.updateUser(user)

    suspend fun deleteUser(user: User) = userDao.deleteUser(user)

    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()

    fun getUserByID(id: Int): Flow<User> = userDao.getUserByID(id)
}