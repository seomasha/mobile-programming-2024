package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.InvestorDao
import com.example.ibustartup.backend.tables.Investor
import kotlinx.coroutines.flow.Flow

class InvestorRepository (private val investorDao: InvestorDao): BaseRepository<Investor> {
    override suspend fun insert(t: Investor) = investorDao.insertInvestor(t)

    override suspend fun update(t: Investor) = investorDao.updateInvestor(t)

    override suspend fun delete(t: Investor) = investorDao.deleteInvestor(t)

    override suspend fun upsert(t: Investor) = investorDao.upsertInvestor(t)

    override fun getAll(): Flow<List<Investor>> = investorDao.getAllInvestors()

    override fun getByID(id: Int): Flow<Investor> = investorDao.getInvestorByID(id)
}