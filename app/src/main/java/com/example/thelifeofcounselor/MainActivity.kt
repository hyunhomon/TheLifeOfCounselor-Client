package com.example.thelifeofcounselor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thelifeofcounselor.ui.screen.MainScreen
import com.example.thelifeofcounselor.ui.theme.TheLifeOfCounselorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberNavController()

            TheLifeOfCounselorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Navigation(
                        navHostController = navHostController,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@Composable
private fun Navigation(
    navHostController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .navigationBarsPadding(),
        navController = navHostController,
        startDestination = Router.MainScreen
    ) {
        composable(Router.MainScreen) { MainScreen(navHostController) }
    }
}