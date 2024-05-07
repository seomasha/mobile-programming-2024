package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserDao): UserRepository {
    override fun getAllUsersStream(): Flow<List<User>> = userDao.getAllUsers()

    override fun getItemStream(id: Int): Flow<User?> = userDao.getUserByID(id)

    override suspend fun insertUser(user: User) = userDao.insertUser(user)

    override suspend fun deleteUser(user: User) = userDao.deleteUser(user)

    override suspend fun updateUser(user: User) = userDao.updateUser(user)
}