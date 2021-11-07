package ru.isaevsv.chuck_norris_api.screens.jokes_screen.model

sealed class JokesEvent {
    data class ChangeCountOfJoke(val value: String) : JokesEvent()
    data class Reload(val numberJokes: String): JokesEvent()
    object FirstLaunch : JokesEvent()
}
