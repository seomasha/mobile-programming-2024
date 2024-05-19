package com.example.ibustartup.backend.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibustartup.backend.repositories.StartupRepository
import com.example.ibustartup.backend.tables.Startup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

sealed class StartupEvent {
    data class AddStartup(val startup: Startup): StartupEvent()
    data class DeleteStartup(val startup: Startup): StartupEvent()
    data class EditStartup(val startup: Startup): StartupEvent()
    object GetStartups: StartupEvent()
    data class GetStartupsByUserID(val userID: Int): StartupEvent()
    data class GetStartupById(val id: Int): StartupEvent()
}

class StartupViewModel(private val startupRepository: StartupRepository, private val userViewModel: UserViewModel): ViewModel() {
    private val _uiState = MutableStateFlow<StartupUIState>(StartupUIState.Loading)
    val uiState: StateFlow<StartupUIState> = _uiState

    /* init {
        onEvent(StartupEvent.GetStartups)
    }
    */
    fun onEvent(event: StartupEvent) {
        when(event) {
            is StartupEvent.AddStartup -> addStartup(event.startup)
            is StartupEvent.DeleteStartup -> deleteStartup(event.startup)
            is StartupEvent.EditStartup -> editStartup(event.startup)
            is StartupEvent.GetStartups -> getStartups()
            is StartupEvent.GetStartupsByUserID -> getStartupsByUserID(event.userID)
            is StartupEvent.GetStartupById -> getStartupById(event.id)
            else -> {}
        }
    }

    private fun addStartup(startup: Startup) {
        viewModelScope.launch {
            try {
                val startupFromDB = startupRepository.getByID(startup.id).firstOrNull()

                if(startupFromDB?.id != null) {
                    _uiState.value = StartupUIState.Error("Startup with that ID already exists.")
                }

                else {
                    startupRepository.insert(startup)
                    _uiState.value = StartupUIState.Success
                    val userID = userViewModel.getLoggedInUserId()
                    onEvent(StartupEvent.GetStartupsByUserID(userID))
                    //onEvent(StartupEvent.GetStartups)
                    //onEvent(StartupEvent.GetStartupsByUserID(userViewModel.getLoggedInUserId()))
                }
            }
            catch (e: Exception) {
                _uiState.value = StartupUIState.Error("An exception happened.")
            }
        }
    }

    private fun deleteStartup(startup: Startup) {
        viewModelScope.launch {
            try {
                startupRepository.delete(startup)
                _uiState.value = StartupUIState.Success
                val userID = userViewModel.getLoggedInUserId()
                onEvent(StartupEvent.GetStartupsByUserID(userID))
                //onEvent(StartupEvent.GetStartups)
            }
            catch (e: Exception) {
                _uiState.value = StartupUIState.Error("An exception happened.")
            }
        }
    }

    private fun editStartup(startup: Startup) {
        viewModelScope.launch {
            try {
                startupRepository.update(startup)
                _uiState.value = StartupUIState.Success
                val userID = userViewModel.getLoggedInUserId()
                onEvent(StartupEvent.GetStartupsByUserID(userID))
                //onEvent(StartupEvent.GetStartups)
            }
            catch (e: Exception) {
                _uiState.value = StartupUIState.Error("An exception happened.")
            }
        }
    }

    private fun getStartups() {
        viewModelScope.launch {
            try {
                val startups = startupRepository.getAll().firstOrNull()
                if (startups != null) {
                    _uiState.value = StartupUIState.SuccessWithData(startups)
                    Log.d("StartupViewModel", "Loaded startups: ${startups.size}")
                } else {
                    _uiState.value = StartupUIState.Error("No startups found.")
                    Log.d("StartupViewModel", "No startups found")
                }
            } catch (e: Exception) {
                _uiState.value = StartupUIState.Error("An exception happened.")
                Log.e("StartupViewModel", "Exception fetching startups", e)
            }
        }
    }

    private fun getStartupsByUserID(userID: Int) {
        viewModelScope.launch {
            try {
                val startups = startupRepository.getStartupByUserID(userID).firstOrNull()
                if (startups != null) {
                    _uiState.value = StartupUIState.SuccessWithData(startups)
                } else {
                    _uiState.value = StartupUIState.Error("No startups found for user ID: $userID.")
                }
            } catch (e: Exception) {
                _uiState.value = StartupUIState.Error("An exception happened while fetching startups for user ID: $userID.")
            }
        }
    }

    fun getStartupById(id: Int): Startup? {
        return runBlocking {
            startupRepository.getByID(id).firstOrNull()
        }
    }

    fun resetUIState() {
        _uiState.value = StartupUIState.Loading
    }
}

sealed class StartupUIState {
    object Loading: StartupUIState()
    object Success: StartupUIState()
    data class SuccessWithData(val startups: List<Startup>): StartupUIState()
    data class Error(val message: String): StartupUIState()
}
