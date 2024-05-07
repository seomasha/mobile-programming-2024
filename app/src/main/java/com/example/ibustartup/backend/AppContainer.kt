package com.example.ibustartup.backend

import android.content.Context
import com.example.ibustartup.backend.repositories.OfflineUserRepository
import com.example.ibustartup.backend.repositories.UserRepository

interface AppContainer {
    val usersRepository: UserRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val usersRepository: UserRepository by lazy {
        OfflineUserRepository(IBUStartupDatabase.getDatabase(context).userDao())
    }
}