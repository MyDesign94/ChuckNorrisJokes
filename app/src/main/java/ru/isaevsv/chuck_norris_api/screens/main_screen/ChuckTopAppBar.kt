package ru.isaevsv.chuck_norris_api.screens.main_screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination
import ru.isaevsv.chuck_norris_api.R
import ru.isaevsv.chuck_norris_api.core.Screens
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun ChuckTopAppBar(
    currentDestination: NavDestination?,
    standardPadding: Dp = NorrisTheme.shapes.standardPadding,
    bigPadding: Dp = NorrisTheme.shapes.bigPadding,
    textColor: Color = NorrisTheme.colors.primaryBackground,
    textStyle: TextStyle = NorrisTheme.typography.toolbar,
    backgroundColor: Color = NorrisTheme.colors.tintColor,
    elevation: Dp = NorrisTheme.shapes.elevation
) {
    TopAppBar(
        modifier = Modifier.height(dimensionResource(id = R.dimen.barSize)),
        backgroundColor = backgroundColor,
        elevation = elevation
    ) {
        Text(
            modifier = Modifier.padding(start = bigPadding, top = standardPadding, bottom = standardPadding),
            text = when (currentDestination?.route) {
                Screens.JokesScreens.route -> stringResource(id = R.string.jokes)
                else -> stringResource(id = R.string.api_info)
            },
            style = textStyle,
            color = textColor
        )
    }
}