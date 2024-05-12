package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Investor
import kotlinx.coroutines.flow.Flow

@Dao
interface InvestorDao {
    @Upsert
    suspend fun upsertInvestor(investor: Investor)

    @Insert
    suspend fun insertInvestor(investor: Investor)

    @Update
    suspend fun updateInvestor(investor: Investor)

    @Delete
    suspend fun deleteInvestor(investor: Investor)

    @Query("SELECT * FROM investors")
    fun getAllInvestors(): Flow<List<Investor>>

    @Query("SELECT * FROM investors WHERE id = :id")
    fun getInvestorByID(id: Int): Flow<Investor>
}