package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.InvestorApplyDao
import com.example.ibustartup.backend.tables.InvestorApply
import kotlinx.coroutines.flow.Flow

class InvestorApplyRepository(private val investorApplyDao: InvestorApplyDao): BaseRepository<InvestorApply> {
    override suspend fun insert(t: InvestorApply) = investorApplyDao.insertInvestorApply(t)

    override suspend fun update(t: InvestorApply) = investorApplyDao.updateInvestorApply(t)

    override suspend fun delete(t: InvestorApply) = investorApplyDao.deleteInvestorApply(t)

    override suspend fun upsert(t: InvestorApply) = investorApplyDao.upsertInvestorApply(t)

    override fun getAll(): Flow<List<InvestorApply>> = investorApplyDao.getAllInvestorApplies()

    override fun getByID(id: Int): Flow<InvestorApply> = investorApplyDao.getInvestorApplyByID(id)

}