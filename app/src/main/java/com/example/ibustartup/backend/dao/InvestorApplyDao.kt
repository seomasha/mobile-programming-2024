package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.InvestorApply
import kotlinx.coroutines.flow.Flow

@Dao
interface InvestorApplyDao {

    @Upsert
    suspend fun upsertInvestorApply(investorApply: InvestorApply)

    @Insert
    suspend fun insertInvestorApply(investorApply: InvestorApply)

    @Update
    suspend fun updateInvestorApply(investorApply: InvestorApply)

    @Delete
    suspend fun deleteInvestorApply(investorApply: InvestorApply)

    @Query("SELECT * FROM investor_applies")
    fun getAllInvestorApplies(): Flow<List<InvestorApply>>

    @Query("SELECT * FROM investor_applies WHERE id = :id")
    fun getInvestorApplyByID(id: Int): Flow<InvestorApply>
}