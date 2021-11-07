package ru.isaevsv.chuck_norris_api.screens.shered_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import ru.isaevsv.chuck_norris_api.R
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NorrisTheme.colors.secondaryBackground,
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    padding: Dp = NorrisTheme.shapes.standardPadding,
    contentColor: Color = NorrisTheme.colors.tintColor,
    textColor: Color = NorrisTheme.colors.primaryText,
    textStyle: TextStyle = NorrisTheme.typography.body,
    elevation: Dp = NorrisTheme.shapes.elevation,
    message: String,
    onReloadClick: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Box {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .align(Alignment.Center),
                horizontalAlignment = contentAlignment
            ) {
                Icon(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.error_icon_size))
                        .align(contentAlignment),
                    imageVector = Icons.Filled.Error,
                    tint = contentColor,
                    contentDescription = stringResource(R.string.error_Icon)
                )
                Text(
                    modifier = Modifier.padding(top = padding),
                    text = message,
                    textAlign = TextAlign.Center,
                    style = textStyle,
                    color = textColor
                )
                Button(
                    modifier = Modifier
                        .padding(top = padding)
                        .height(dimensionResource(id = R.dimen.buttonHeight))
                        .fillMaxWidth(),
                    onClick = onReloadClick,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = contentColor
                    ),
                    elevation = ButtonDefaults.elevation(elevation)
                ) {
                    Text(
                        text = stringResource(id = R.string.reload),
                        style = textStyle,
                        color = backgroundColor
                    )
                }
            }
        }
    }
}
