package com.example.ibustartup.backend.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibustartup.backend.viewmodels.PositionEvent
import com.example.ibustartup.backend.repositories.UserRepository
import com.example.ibustartup.backend.tables.Startup
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

sealed class UserEvent {
    data class SaveUser(val user: User): UserEvent()
    data class Login(val email: String, val password: String): UserEvent()
    data class EditUser(val user: User): UserEvent()
}

class UserViewModel(private val userRepository: UserRepository): ViewModel() {
    val uiState: MutableLiveData<UIState> = MutableLiveData()
    private var loggedInUserId: Int = 0

    fun onEvent(event: UserEvent) {
        when(event) {
            is UserEvent.SaveUser -> addUser(event.user)
            is UserEvent.Login -> login(event.email, event.password)
            is UserEvent.EditUser -> editUser(event.user)
            else -> {}
        }
    }

    private fun addUser(user: User) {
        viewModelScope.launch {
            try {
                val userFromDB = userRepository.getByEmail(user.email).firstOrNull()

                if(userFromDB?.email != null) {
                    uiState.value = UIState.Error("That email address has already been used.")
                }

                else {
                    userRepository.insert(user)
                    uiState.value = UIState.Success
                }
            }
            catch (e: Exception) {
                uiState.value = UIState.Error("An exception happened.")
            }
        }
    }

    private fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = userRepository.getByEmail(email).firstOrNull()

                if(user?.password == password) {
                    loggedInUserId = user.id
                    uiState.value = UIState.LoggedIn
                    Log.d("USER ID", loggedInUserId.toString())
                } else {
                    uiState.value = UIState.Error("Your password is incorrect.")
                }
            }
            catch (e: Exception) {
                uiState.value = UIState.Error("An exception happened.")
            }
        }
    }

    private fun editUser(user: User) {
        viewModelScope.launch {
            try {
                userRepository.update(user)
                uiState.value = UIState.Success
                //onEvent(StartupEvent.GetStartups)
            }
            catch (e: Exception) {
                uiState.value = UIState.Error("An exception happened.")
            }
        }
    }

    fun resetUIState() {
        uiState.value = UIState.Loading
    }

    fun getLoggedInUserId(): Int {
        return loggedInUserId
    }
    fun getUserById(id: Int): User?{
        return runBlocking { userRepository.getByID(id).firstOrNull() }
    }
}

sealed class UIState {
    object Loading: UIState()
    object Success: UIState()
    object LoggedIn: UIState()
    object Registering: UIState()
    data class Error(val message: String): UIState()
}