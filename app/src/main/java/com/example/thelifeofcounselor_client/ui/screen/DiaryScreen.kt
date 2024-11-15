package com.example.thelifeofcounselor_client.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.thelifeofcounselor_client.data.PreferencesManager
import com.example.thelifeofcounselor_client.ui.viewmodel.DiaryViewModel

@Composable
fun DiaryScreen(
    navController: NavController,
    preferencesManager: PreferencesManager,
    viewModel: DiaryViewModel
) {
    Column {
        Text(text = "welcome to diary")
    }
}