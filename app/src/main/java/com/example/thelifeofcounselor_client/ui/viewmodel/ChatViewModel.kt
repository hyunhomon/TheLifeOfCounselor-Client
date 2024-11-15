package com.example.thelifeofcounselor_client.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {
    val isLoading = MutableStateFlow(false)
    val client = MutableStateFlow("")

    private val _prompt = MutableStateFlow("")
    val prompt: StateFlow<String> = _prompt

    private val _cureRate = MutableStateFlow(0)
    val cureRate: StateFlow<Int> = _cureRate

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            isLoading.value = true

            isLoading.value = false
        }
    }

    fun updatePrompt(newPrompt: String) {
        _prompt.value = newPrompt
    }
}