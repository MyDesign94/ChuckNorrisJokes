package ru.isaevsv.chuck_norris_api.screens.jokes_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import ru.isaevsv.chuck_norris_api.core.Constants.INIT_PARAM
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.component.DisplayJokeView
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.model.JokesEvent
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.model.JokesViewState
import ru.isaevsv.chuck_norris_api.screens.shered_screen.ErrorView
import ru.isaevsv.chuck_norris_api.screens.shered_screen.LoadingView

@Composable
fun JokesScreen(viewModel: JokesViewModel) {

    val jokesViewState = viewModel.viewState.observeAsState()

    when(val state = jokesViewState.value) {
        is JokesViewState.Loading -> LoadingView()
        is JokesViewState.Error -> ErrorView(
            message = state.value,
            onReloadClick = { viewModel.obtainEvent(JokesEvent.Reload(INIT_PARAM)) }
        )
        is JokesViewState.DisplayJoke ->  DisplayJokeView(
            listJokes = state.jokes,
            countVale = state.countJokes,
            onValueChange = { viewModel.obtainEvent(JokesEvent.ChangeCountOfJoke(value = it)) },
            onReloadClick = { viewModel.obtainEvent(JokesEvent.Reload(state.countJokes)) }
        )
    }

    LaunchedEffect(key1 = jokesViewState, block = { viewModel.obtainEvent(JokesEvent.FirstLaunch) })
}