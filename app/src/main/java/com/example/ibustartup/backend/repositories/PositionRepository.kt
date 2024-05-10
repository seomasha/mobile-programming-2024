package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.PositionDao
import com.example.ibustartup.backend.tables.Position
import kotlinx.coroutines.flow.Flow

class PositionRepository(private val positionDao: PositionDao): BaseRepository<Position> {
    override suspend fun insert(t: Position) = positionDao.insertPosition(t)

    override suspend fun update(t: Position) = positionDao.updatePosition(t)

    override suspend fun delete(t: Position) = positionDao.deletePosition(t)

    override suspend fun upsert(t: Position) = positionDao.upsertPosition(t)

    override fun getAll(): Flow<List<Position>> = positionDao.getAllPositions()

    override fun getByID(id: Int): Flow<Position> = positionDao.getPositionByID(id)

}