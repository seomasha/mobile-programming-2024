package com.example.ibustartup.backend.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibustartup.backend.repositories.UserRepository
import com.example.ibustartup.backend.tables.User
import kotlinx.coroutines.launch

sealed class UserEvent {
    data class SaveUser(val user: User): UserEvent()
}

class UserViewModel(private val userRepository: UserRepository): ViewModel() {
    val uiState: MutableLiveData<UIState> = MutableLiveData()

    fun onEvent(event: UserEvent) {
        when(event) {
            is UserEvent.SaveUser -> addUser(event.user)
            else -> {}
        }
    }

    private fun addUser(user: User) {
        viewModelScope.launch {
            try {
                userRepository.insert(user)
                uiState.value = UIState.Success
            }
            catch (e: Exception) {
                uiState.value = UIState.Error(e)
            }
        }
    }
}

sealed class UIState {
    object Loading: UIState()
    object Success: UIState()
    data class Error(val exception: Exception): UIState()
}