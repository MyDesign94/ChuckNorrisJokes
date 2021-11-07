package ru.isaevsv.chuck_norris_api.screens.main_screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import ru.isaevsv.chuck_norris_api.R
import ru.isaevsv.chuck_norris_api.core.Screens
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun ChuckBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    backgroundColor: Color = NorrisTheme.colors.primaryBackground
) {
    val screens = listOf(
        Screens.JokesScreens,
        Screens.WebScreens
    )

    BottomNavigation(
        modifier = Modifier.height(dimensionResource(id = R.dimen.barSize)),
        backgroundColor = backgroundColor
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    navController: NavHostController,
    screen: Screens,
    currentDestination: NavDestination?,
    unselectedContentColor: Color = NorrisTheme.colors.controlColor,
    selectedContentColor: Color = NorrisTheme.colors.tintColor
) {
    BottomNavigationItem(
        label = { Text(text = stringResource(id = screen.resourceId)) },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                modifier = Modifier.size(dimensionResource(id = R.dimen.iconBottomBarSize)),
                contentDescription = stringResource(R.string.bottom_icon),
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = unselectedContentColor,
        selectedContentColor = selectedContentColor,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}