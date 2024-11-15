package com.example.thelifeofcounselor_client.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DiaryViewModel: ViewModel() {
    val isLoading = MutableStateFlow(false)

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            isLoading.value = true

            isLoading.value = false
        }
    }
}