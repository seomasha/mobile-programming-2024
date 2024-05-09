package com.example.ibustartup.backend

import android.content.Context
import com.example.ibustartup.backend.repositories.CommentRepository
import com.example.ibustartup.backend.repositories.InvestorApplyRepository
import com.example.ibustartup.backend.repositories.PositionRepository
import com.example.ibustartup.backend.repositories.UserRepository
import com.example.ibustartup.backend.tables.InvestorApply


interface AppContainer {
    val commentRepository: CommentRepository
    val userRepository: UserRepository
    val positionRepository: PositionRepository
    val investorApplyRepository: InvestorApplyRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    override val commentRepository: CommentRepository by lazy {
        CommentRepository(IBUStartupDatabase.getDatabase(context).commentDao())
    }

    override val userRepository: UserRepository by lazy {
        UserRepository(IBUStartupDatabase.getDatabase(context).userDao())
    }

    override val positionRepository: PositionRepository by lazy {
        PositionRepository(IBUStartupDatabase.getDatabase(context).positionDao())
    }

    override val investorApplyRepository: InvestorApplyRepository by lazy {
        InvestorApplyRepository(IBUStartupDatabase.getDatabase(context).investorApplyDao())
    }

}