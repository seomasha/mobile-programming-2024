package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.InvestorApplyDao
import com.example.ibustartup.backend.tables.InvestorApply
import kotlinx.coroutines.flow.Flow

class InvestorApplyRepository(private val investorApplyDao: InvestorApplyDao) {

    suspend fun upsertInvestorApply(investorApply: InvestorApply) = investorApplyDao.upsertInvestorApply(investorApply)

    suspend fun insertInvestorApply(investorApply: InvestorApply) = investorApplyDao.insertInvestorApply(investorApply)

    suspend fun updateInvestorApply(investorApply: InvestorApply) = investorApplyDao.updateInvestorApply(investorApply)

    suspend fun deleteInvestorApply(investorApply: InvestorApply) = investorApplyDao.deleteInvestorApply(investorApply)

    fun getAllInvestorApplies(): Flow<List<InvestorApply>> = investorApplyDao.getAllInvestorApplies()

    fun getInvestorApplyByID(id: Int) = investorApplyDao.getInvestorApplyByID(id)
}