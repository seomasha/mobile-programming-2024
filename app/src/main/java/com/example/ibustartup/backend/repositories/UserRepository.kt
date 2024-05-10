package com.example.ibustartup.backend.repositories


import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao): BaseRepository<User> {
    override suspend fun insert(t: User) = userDao.insertUser(t)

    override suspend fun update(t: User) = userDao.updateUser(t)

    override suspend fun delete(t: User) = userDao.deleteUser(t)

    override suspend fun upsert(t: User) = userDao.upsertUser(t)

    override fun getAll(): Flow<List<User>> = userDao.getAllUsers()

    override fun getByID(id: Int): Flow<User> = userDao.getUserByID(id)

}