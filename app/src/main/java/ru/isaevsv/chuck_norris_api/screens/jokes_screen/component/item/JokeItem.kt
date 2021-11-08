package ru.isaevsv.chuck_norris_api.screens.jokes_screen.component.item

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun JokeItem(
    modifier: Modifier = Modifier,
    value: String,
    smallPadding: Dp = NorrisTheme.shapes.smallPadding,
    standardPadding: Dp = NorrisTheme.shapes.standardPadding,
    backgroundColor: Color = NorrisTheme.colors.primaryBackground,
    textStyle: TextStyle = NorrisTheme.typography.body,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = NorrisTheme.colors.primaryText,
    elevation: Dp = NorrisTheme.shapes.elevation
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = smallPadding, bottom = smallPadding),
        backgroundColor = backgroundColor,
        elevation = elevation
    ) {
        Text(
            modifier = modifier.padding(standardPadding).fillMaxWidth(),
            text = value,
            textAlign = textAlign,
            color = textColor,
            style = textStyle
        )
    }
}