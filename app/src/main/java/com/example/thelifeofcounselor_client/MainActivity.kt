package com.example.thelifeofcounselor_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thelifeofcounselor_client.data.PreferencesManager
import com.example.thelifeofcounselor_client.ui.screen.ChatScreen
import com.example.thelifeofcounselor_client.ui.screen.DiaryScreen
import com.example.thelifeofcounselor_client.ui.screen.StartScreen
import com.example.thelifeofcounselor_client.ui.theme.TheLifeOfCounselorClientTheme
import com.example.thelifeofcounselor_client.ui.viewmodel.ChatViewModel
import com.example.thelifeofcounselor_client.ui.viewmodel.DiaryViewModel
import com.example.thelifeofcounselor_client.ui.viewmodel.StartViewModel

class MainActivity : ComponentActivity() {
    private val preferencesManager: PreferencesManager by lazy {
        PreferencesManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberNavController()

            TheLifeOfCounselorClientTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { Navigation(preferencesManager, navHostController, it) }
                )
            }
        }
    }
}

@Composable
fun Navigation(
    preferencesManager: PreferencesManager,
    navHostController: NavHostController,
    innerPadding: PaddingValues
) {
    val startViewModel: StartViewModel = viewModel()
    val diaryViewModel: DiaryViewModel = viewModel()
    val chatViewModel: ChatViewModel = viewModel()

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .navigationBarsPadding(),
        navController = navHostController,
        startDestination = if (preferencesManager.getUser().isEmpty()) Router.StartScreen
        else Router.DiaryScreen
    ) {
        composable(Router.StartScreen) { StartScreen(navHostController, preferencesManager, startViewModel) }
        composable(Router.DiaryScreen) { DiaryScreen(navHostController, preferencesManager, diaryViewModel) }
        composable(Router.ChatScreen) { ChatScreen(navHostController, preferencesManager, chatViewModel) }
    }
}