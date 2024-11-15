package com.example.thelifeofcounselor_client.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thelifeofcounselor_client.data.PreferencesManager
import com.example.thelifeofcounselor_client.ui.component.InputFieldWithBtn
import com.example.thelifeofcounselor_client.ui.component.ProgressBarWithClose
import com.example.thelifeofcounselor_client.ui.viewmodel.ChatViewModel

@Composable
fun ChatScreen(
    navController: NavController,
    preferencesManager: PreferencesManager,
    viewModel: ChatViewModel
) {
    val isLoading = viewModel.isLoading.collectAsState()
    val prompt = viewModel.prompt.collectAsState()

    val client = viewModel.client.collectAsState()
    val cureRate = viewModel.cureRate.collectAsState()

    Column {
        ProgressBarWithClose(
            currentProgress = cureRate.value,
            maxProgress = 100,
            onClose = {}
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {}
        InputFieldWithBtn(
            modifier = Modifier
                .padding(16.dp, 20.dp),
            placeholder = "${client.value}에게 말을 건네보세요",
            value = prompt.value,
            onValueChange = { viewModel.updatePrompt(it) },
            onClickBtn = {}
        )
    }
}