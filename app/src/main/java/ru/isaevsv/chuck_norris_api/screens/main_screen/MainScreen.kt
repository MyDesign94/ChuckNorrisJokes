package ru.isaevsv.chuck_norris_api.screens.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = NorrisTheme.colors.secondaryBackground,
        topBar = { ChuckTopAppBar(currentDestination = currentDestination) },
        bottomBar = {
            ChuckBottomBar(
                navController = navController,
                currentDestination = currentDestination
            )
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}