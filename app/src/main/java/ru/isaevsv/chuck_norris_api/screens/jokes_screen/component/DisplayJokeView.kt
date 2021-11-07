package ru.isaevsv.chuck_norris_api.screens.jokes_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.isaevsv.chuck_norris_api.R
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.component.item.JokeItem
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun DisplayJokeView(
    modifier: Modifier = Modifier,
    listJokes: List<String>,
    countVale: String,
    padding: Dp = NorrisTheme.shapes.standardPadding,
    primaryTextColor: Color = NorrisTheme.colors.primaryText,
    tintColor: Color = NorrisTheme.colors.tintColor,
    primaryBackgroundColor: Color = NorrisTheme.colors.primaryBackground,
    secondaryBackgroundColor: Color = NorrisTheme.colors.secondaryBackground,
    textStyle: TextStyle = NorrisTheme.typography.body,
    elevation: Dp = NorrisTheme.shapes.elevation,
    onValueChange: (String) -> Unit,
    onReloadClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Surface(
        modifier = modifier
            .padding(start = padding, end = padding, bottom = padding)
            .fillMaxSize(),
        color = secondaryBackgroundColor
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                listJokes.forEachIndexed { index, joke ->
                    item {
                        JokeItem(value = "№${index + 1}: $joke")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = padding, bottom = padding)
                    .height(dimensionResource(id = R.dimen.buttonHeight)),
                horizontalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    elevation = elevation
                ) {
                    TextField(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(primaryBackgroundColor),
                        value = countVale,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                        textStyle = TextStyle(
                            color = primaryTextColor,
                            fontSize = textStyle.fontSize,
                            fontWeight = textStyle.fontWeight
                        ),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = tintColor,
                            unfocusedIndicatorColor = primaryBackgroundColor,
                            cursorColor = tintColor,
                            backgroundColor = primaryBackgroundColor,
                        ),
                        onValueChange = onValueChange,
                        placeholder = {
                            Text(
                                text = stringResource(R.string.hintTextField),
                                style = textStyle,
                                color = tintColor
                            )
                        }
                    )
                }
                Button(
                    modifier = Modifier
                        .weight(1.5f)
                        .fillMaxHeight()
                        .padding(start = padding),
                    onClick = onReloadClick,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = tintColor
                    ),
                    elevation = ButtonDefaults.elevation(elevation)
                ) {
                    Text(
                        text = stringResource(R.string.reload),
                        style = textStyle,
                        color = primaryBackgroundColor
                    )
                }
            }
            Spacer(modifier = modifier.height(40.dp))
        }
    }
}