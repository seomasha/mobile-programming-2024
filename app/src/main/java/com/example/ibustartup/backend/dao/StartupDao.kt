package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Startup
import kotlinx.coroutines.flow.Flow

@Dao
interface StartupDao {
    @Upsert
    suspend fun upsertStartup(startup: Startup)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStartup(startup: Startup)

    @Update
    suspend fun updateStartup(startup: Startup)

    @Delete
    suspend fun deleteStartup(startup: Startup)

    @Query("SELECT * FROM startups")
    fun getAllStartups(): Flow<List<Startup>>

    @Query("SELECT * FROM startups WHERE id = :id")
    fun getStartupByID(id: Int): Flow<Startup>
}