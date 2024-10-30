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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thelifeofcounselor.ui.component.BottomNavigationBar
import com.example.thelifeofcounselor.ui.screen.CounselScreen
import com.example.thelifeofcounselor.ui.screen.EmployScreen
import com.example.thelifeofcounselor.ui.screen.HospitalScreen
import com.example.thelifeofcounselor.ui.screen.RecordScreen
import com.example.thelifeofcounselor.ui.theme.TheLifeOfCounselorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberNavController()
            val visibleScreens = setOf(Router.HospitalScreen, Router.EmployScreen, Router.CounselScreen, Router.RecordScreen)
            val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route

            TheLifeOfCounselorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (currentRoute in visibleScreens) {
                            BottomNavigationBar(navController = navHostController)
                        }
                    },
                    content = { innerPadding ->
                        Navigation(navHostController, innerPadding)
                    }
                )
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
        startDestination = Router.HospitalScreen
    ) {
        composable(Router.HospitalScreen) { HospitalScreen(navHostController) }
        composable(Router.EmployScreen) { EmployScreen(navHostController) }
        composable(Router.CounselScreen) { CounselScreen(navHostController) }
        composable(Router.RecordScreen) { RecordScreen(navHostController) }
    }
}