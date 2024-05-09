package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.tables.Comment
import kotlinx.coroutines.flow.Flow

interface BaseRepository<T> {

    suspend fun insert(t: T)

    suspend fun update(t: T)

    suspend fun delete(t: T)

    suspend fun upsert(t: T)

    fun getAll(): Flow<List<T>>

    fun getByID(id: Int): Flow<T>
}