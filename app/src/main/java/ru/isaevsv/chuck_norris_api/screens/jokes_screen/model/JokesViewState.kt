package ru.isaevsv.chuck_norris_api.screens.jokes_screen.model

sealed class JokesViewState {
    object Loading: JokesViewState()
    data class Error(val value: String): JokesViewState()
    data class DisplayJoke(
        val jokes: List<String>,
        val countJokes: String
    ): JokesViewState()
}
