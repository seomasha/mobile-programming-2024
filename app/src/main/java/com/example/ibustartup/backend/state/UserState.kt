package com.example.ibustartup.backend.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.ibustartup.backend.tables.User

data class UserState(
    val users: List<User> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val isAddingUser: Boolean = false
)