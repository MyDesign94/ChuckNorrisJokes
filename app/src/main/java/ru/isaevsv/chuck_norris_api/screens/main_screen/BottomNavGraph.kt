package ru.isaevsv.chuck_norris_api.screens.main_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.isaevsv.chuck_norris_api.core.Screens
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.JokesScreen
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.JokesViewModel
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.WebScreen
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.WebViewViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.JokesScreens.route
    ) {
        composable(Screens.JokesScreens.route) {
            val jokesViewModel = hiltViewModel<JokesViewModel>()
            JokesScreen(
                viewModel = jokesViewModel
            )
        }

        composable(Screens.WebScreens.route) {
            val webViewModel = hiltViewModel<WebViewViewModel>()
            WebScreen(
                viewModel = webViewModel
            )
        }
    }
}
