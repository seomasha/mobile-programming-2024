package com.example.ibustartup.backend.viewmodels

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibustartup.backend.IBUStartupDatabase
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.events.UserEvent
import com.example.ibustartup.backend.state.UserState
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class UserViewModel(private val dao: UserDao): ViewModel() {

    private var users = dao.getAllUsers().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val _state = MutableStateFlow(UserState())
    val state = combine(_state, users) { state, users ->
        state.copy(
            users = users
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserState())

    fun onEvent(event: UserEvent) {
        when(event) {
            is UserEvent.DeleteUser -> {
                viewModelScope.launch {
                    dao.deleteUser(event.user)
                }
            }
            UserEvent.SaveUser -> {
                val firstName = state.value.firstName
                val lastName = state.value.lastName
                val email = state.value.email
                val password = state.value.password

                if(firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank()) {
                    return
                }

                val user = User(
                    firstName = firstName,
                    lastName = lastName,
                    email = email,
                    password = password
                )

                viewModelScope.launch {
                    dao.upsertUser(user = user)
                }

                _state.update { it.copy(
                    isAddingUser = false,
                    firstName = "",
                    lastName = "",
                    email = "",
                    password = ""
                ) }
            }
            is UserEvent.SetEmail -> {
                _state.update { it.copy(
                    email = event.email
                ) }
            }
            is UserEvent.SetFirstName -> {
                _state.update { it.copy(
                    firstName = event.firstName
                ) }
            }
            is UserEvent.SetLastName -> {
                _state.update { it.copy(
                    lastName = event.lastName
                ) }
            }
            is UserEvent.SetPassword -> {
                _state.update { it.copy(
                    password = event.password
                ) }
            }
        }
    }
}