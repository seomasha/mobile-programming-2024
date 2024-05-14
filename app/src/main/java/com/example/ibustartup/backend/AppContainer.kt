package com.example.ibustartup.backend

import android.content.Context
import com.example.ibustartup.backend.repositories.CommentRepository
import com.example.ibustartup.backend.repositories.FriendsRepository
import com.example.ibustartup.backend.repositories.InvestorApplyRepository
import com.example.ibustartup.backend.repositories.InvestorRepository
import com.example.ibustartup.backend.repositories.NotificationRepository
import com.example.ibustartup.backend.repositories.PositionRepository
import com.example.ibustartup.backend.repositories.StartupRepository
import com.example.ibustartup.backend.repositories.UserRepository
import com.example.ibustartup.backend.tables.Notification
import com.example.ibustartup.backend.tables.Startup


interface AppContainer {
    val commentRepository: CommentRepository
    val userRepository: UserRepository
    val positionRepository: PositionRepository
    val investorApplyRepository: InvestorApplyRepository
    val friendsRepository: FriendsRepository
    val investorRepository: InvestorRepository
    val notificationRepository: NotificationRepository
    val startupRepository: StartupRepository
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

    override val friendsRepository: FriendsRepository by lazy {
        FriendsRepository(IBUStartupDatabase.getDatabase(context).friendDao())
    }

    override val investorRepository: InvestorRepository by lazy {
        InvestorRepository(IBUStartupDatabase.getDatabase(context).investorDao())
    }

    override val notificationRepository: NotificationRepository by lazy {
        NotificationRepository(IBUStartupDatabase.getDatabase(context).notificationDao())
    }

    override val startupRepository: StartupRepository by lazy {
        StartupRepository(IBUStartupDatabase.getDatabase(context).startupDao())
    }
}