package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.PositionDao
import com.example.ibustartup.backend.tables.Position
import kotlinx.coroutines.flow.Flow

class PositionRepository(private val positionDao: PositionDao) {

    suspend fun upsertPosition(position: Position) = positionDao.upsertPosition(position)

    suspend fun insertPosition(position: Position) = positionDao.insertPosition(position)

    suspend fun updatePosition(position: Position) = positionDao.updatePosition(position)

    suspend fun deletePosition(position: Position) = positionDao.deletePosition(position)

    fun getAllPositions(): Flow<List<Position>> = positionDao.getAllPositions()

    fun getPositionByID(id: Int): Flow<Position> = positionDao.getPositionByID(id)
}