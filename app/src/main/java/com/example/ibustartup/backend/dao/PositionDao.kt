package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Position

@Dao
interface PositionDao {

    @Upsert
    suspend fun upsertPosition(position: Position)

    @Insert
    suspend fun insertPosition(position: Position)

    @Update
    suspend fun updatePosition(position: Position)

    @Delete
    suspend fun deletePosition(position: Position)
}