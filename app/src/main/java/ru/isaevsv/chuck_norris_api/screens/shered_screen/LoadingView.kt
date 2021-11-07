package ru.isaevsv.chuck_norris_api.screens.shered_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import ru.isaevsv.chuck_norris_api.R
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun LoadingView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NorrisTheme.colors.secondaryBackground,
    contentAlignment: Alignment = Alignment.Center,
    progressIndicatorColor: Color = NorrisTheme.colors.tintColor
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = contentAlignment
    ) {
        CircularProgressIndicator(
            modifier = modifier.size(dimensionResource(id = R.dimen.indicatorSize)),
            color = progressIndicatorColor,
            strokeWidth = dimensionResource(id = R.dimen.indicatorWeight)
        )
    }
}