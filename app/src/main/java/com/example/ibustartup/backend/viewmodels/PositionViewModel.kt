package com.example.ibuPosition.backend.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibustartup.backend.repositories.PositionRepository
import com.example.ibustartup.backend.tables.Position
import com.example.ibustartup.backend.viewmodels.UserViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
    private val _UIState = MutableStateFlow<PositionUIState>(PositionUIState.Loading)
    val UIState : StateFlow<PositionUIState> = _UIState

    fun onEvent(event: PositionEvent){
        when(event){
            is PositionEvent.AddPosition -> addPosition(event.Position)
            is PositionEvent.DeletePosition -> deletePosition(event.Position)
            is PositionEvent.EditPosition -> editPosition(event.Position)
            is PositionEvent.GetPositions -> getPositions()
            is PositionEvent.GetPositionById ->  getPositionById(event.id)
        }
    }

    private fun addPosition(Position: Position) {
        viewModelScope.launch {
            try {
                val PositionFromDB = positionRepository.getByID(Position.id).firstOrNull()

                if(PositionFromDB?.id != null) {
                    _UIState.value = PositionUIState.Error("Position with that ID already exists.")
                }

                else {
                    positionRepository.insert(Position)
                    _UIState.value = PositionUIState.Success
                    val userID = userViewModel.getLoggedInUserId()
                    //onEvent(PositionEvent.GetPositionsByUserID(userID))
                    onEvent(PositionEvent.GetPositions)
                    //onEvent(PositionEvent.GetPositionsByUserID(userViewModel.getLoggedInUserId()))
                }
            }
            catch (e: Exception) {
                _UIState.value = PositionUIState.Error("An exception happened.")
            }
        }
    }

    private fun deletePosition(Position: Position) {
        viewModelScope.launch {
            try {
                positionRepository.delete(Position)
                _UIState.value = PositionUIState.Success
                val userID = userViewModel.getLoggedInUserId()
                //onEvent(PositionEvent.GetPositionsByUserID(userID))
                //onEvent(PositionEvent.GetPositions)
            }
            catch (e: Exception) {
                _UIState.value = PositionUIState.Error("An exception happened.")
            }
        }
    }
    private fun editPosition(Position: Position) {
        viewModelScope.launch {
            try {
                positionRepository.update(Position)
                _UIState.value = PositionUIState.Success
                val userID = userViewModel.getLoggedInUserId()
                //(onEvent(PositionEvent.GetPositionsByUserID(userID))
                //onEvent(PositionEvent.GetPositions)
            }
            catch (e: Exception) {
                _UIState.value = PositionUIState.Error("An exception happened.")
            }
        }
    }
    private fun getPositions() {
        viewModelScope.launch {
            try {
                val Positions = positionRepository.getAll().firstOrNull()
                if (Positions != null) {
                    _UIState.value = PositionUIState.SuccessWithData(Positions)
                    Log.d("PositionViewModel", "Loaded Positions: ${Positions.size}")
                } else {
                    _UIState.value = PositionUIState.Error("No Positions found.")
                    Log.d("PositionViewModel", "No Positions found")
                }
            } catch (e: Exception) {
                _UIState.value = PositionUIState.Error("An exception happened.")
                Log.e("PositionViewModel", "Exception fetching Positions", e)
            }
        }
    }
    fun getPositionById(id: Int): Position? {
        return runBlocking {
            positionRepository.getByID(id).firstOrNull()
        }
    }

    fun resetUIState() {
        _UIState.value = PositionUIState.Loading
    }

}