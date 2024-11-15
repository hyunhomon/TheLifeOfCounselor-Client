package com.example.thelifeofcounselor_client.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class StartUiState(
    var page: Int = 0,
    var id: String = "",
    var pw: String = "",
    var pwCheck: String = "",
    var showErrorMessage: Boolean = true
)

class StartViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(StartUiState())
    val uiState: StateFlow<StartUiState> = _uiState

    fun updatePage(newPage: Int) {
        _uiState.value = _uiState.value.copy(page = newPage)
    }
    fun updateId(newId: String) {
        _uiState.value = _uiState.value.copy(id = newId)
    }
    fun updatePw(newPw: String) {
        _uiState.value = _uiState.value.copy(pw = newPw)
    }
    fun updatePwCheck(newPwCheck: String) {
        _uiState.value = _uiState.value.copy(pwCheck = newPwCheck)
    }
    fun updateShowErrorMessage(newShowErrorMessage: Boolean) {
        _uiState.value = _uiState.value.copy(showErrorMessage = newShowErrorMessage)
    }

    fun checkId(): Boolean {
        // id exist
        return false
    }
    fun checkPw(): Boolean {
        // pw correct
        return true
    }

    fun createUser() {}
}