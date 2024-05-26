package com.example.ibustartup.backend.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibustartup.backend.repositories.PositionRepository
import com.example.ibustartup.backend.tables.Position
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

sealed class PositionEvent {
    data class AddPosition(val Position: Position): PositionEvent()
    data class DeletePosition(val Position: Position): PositionEvent()
    data class EditPosition(val Position: Position): PositionEvent()
    object GetPositions: PositionEvent()
    data class GetPositionById(val id: Int): PositionEvent()
}

sealed class PositionUIState {
    object Loading: PositionUIState()
    object Success: PositionUIState()
    data class SuccessWithData(val Positions: List<Position>): PositionUIState()
    data class Error(val message: String): PositionUIState()
}

class PositionViewModel(private val positionRepository: PositionRepository, private val userViewModel: UserViewModel) : ViewModel() {
    private val _uiState = MutableStateFlow<PositionUIState>(PositionUIState.Loading)
    val uiState: StateFlow<PositionUIState> = _uiState

    fun onEvent(event: PositionEvent) {
        when(event) {
            is PositionEvent.AddPosition -> addPosition(event.Position)
            is PositionEvent.DeletePosition -> deletePosition(event.Position)
            is PositionEvent.EditPosition -> editPosition(event.Position)
            is PositionEvent.GetPositions -> getPositions()
            is PositionEvent.GetPositionById -> getPositionById(event.id)
        }
    }

    private fun addPosition(position: Position) {
        viewModelScope.launch {
            try {
                val positionFromDB = positionRepository.getByID(position.id).firstOrNull()
                if (positionFromDB != null) {
                    _uiState.value = PositionUIState.Error("Position with that ID already exists.")
                } else {
                    positionRepository.insert(position)
                    _uiState.value = PositionUIState.Success
                    onEvent(PositionEvent.GetPositions)
                }
            } catch (e: Exception) {
                _uiState.value = PositionUIState.Error("An exception happened: ${e.message}")
            }
        }
    }

    private fun deletePosition(position: Position) {
        viewModelScope.launch {
            try {
                Log.d("Position", "$position")
                positionRepository.delete(position)
                _uiState.value = PositionUIState.Success
                onEvent(PositionEvent.GetPositions)
            } catch (e: Exception) {
                _uiState.value = PositionUIState.Error("An exception happened: ${e.message}")
            }
        }
    }

    private fun editPosition(position: Position) {
        viewModelScope.launch {
            try {
                positionRepository.update(position)
                _uiState.value = PositionUIState.Success
                onEvent(PositionEvent.GetPositions)
            } catch (e: Exception) {
                _uiState.value = PositionUIState.Error("An exception happened: ${e.message}")
            }
        }
    }

    private fun getPositions() {
        viewModelScope.launch {
            try {
                val positions = positionRepository.getAll().firstOrNull()
                if (positions != null) {
                    _uiState.value = PositionUIState.SuccessWithData(positions)
                } else {
                    _uiState.value = PositionUIState.Error("No Positions found.")
                }
            } catch (e: Exception) {
                _uiState.value = PositionUIState.Error("An exception happened: ${e.message}")
            }
        }
    }

    private fun getPositionById(id: Int) {
        viewModelScope.launch {
            try {
                val position = positionRepository.getByID(id).firstOrNull()
                if (position != null) {
                    _uiState.value = PositionUIState.SuccessWithData(listOf(position))
                } else {
                    _uiState.value = PositionUIState.Error("Position not found.")
                }
            } catch (e: Exception) {
                _uiState.value = PositionUIState.Error("An exception happened: ${e.message}")
            }
        }
    }

    fun resetUIState() {
        _uiState.value = PositionUIState.Loading
    }
}