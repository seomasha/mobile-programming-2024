package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Position
import kotlinx.coroutines.flow.Flow

@Dao
interface PositionDao {

    @Upsert
    suspend fun upsertPosition(position: Position)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPosition(position: Position)

    @Update
    suspend fun updatePosition(position: Position)

    @Delete
    suspend fun deletePosition(position: Position)
    @Query("SELECT * FROM positions p")
    fun getAllPositions(): Flow<List<Position>>

    @Query("SELECT * FROM positions WHERE id = :id")
    fun getPositionByID(id: Int): Flow<Position>
}