package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.StartupDao
import com.example.ibustartup.backend.tables.Startup
import kotlinx.coroutines.flow.Flow

class StartupRepository(private val startupDao: StartupDao): BaseRepository<Startup>{
    override suspend fun insert(t: Startup) = startupDao.insertStartup(t)

    override suspend fun update(t: Startup) = startupDao.updateStartup(t)

    override suspend fun delete(t: Startup) = startupDao.deleteStartup(t)

    override suspend fun upsert(t: Startup) = startupDao.upsertStartup(t)

    override fun getAll(): Flow<List<Startup>> = startupDao.getAllStartups()

    override fun getByID(id: Int): Flow<Startup> = startupDao.getStartupByID(id)
}