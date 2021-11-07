package ru.isaevsv.chuck_norris_api.screens.jokes_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.isaevsv.chuck_norris_api.core.Constants.INIT_PARAM
import ru.isaevsv.chuck_norris_api.core.EventHandler
import ru.isaevsv.chuck_norris_api.core.Resource
import ru.isaevsv.chuck_norris_api.domain.use_case.GetJokeUseCase
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.model.JokesEvent
import ru.isaevsv.chuck_norris_api.screens.jokes_screen.model.JokesViewState
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val useCase: GetJokeUseCase
): ViewModel(), EventHandler<JokesEvent> {

    private val _viewState: MutableLiveData<JokesViewState> = MutableLiveData(JokesViewState.Loading)
    val viewState: LiveData<JokesViewState> = _viewState

    override fun obtainEvent(event: JokesEvent) {
        when(val jokeState = _viewState.value) {
            is JokesViewState.Loading -> reduce(event, jokeState)
            is JokesViewState.Error -> reduce(event, jokeState)
            is JokesViewState.DisplayJoke -> reduce(event, jokeState)
        }
    }

    private fun reduce(event: JokesEvent, jokeState: JokesViewState.Loading) {
        when(event) { is JokesEvent.FirstLaunch -> reload(INIT_PARAM) }
    }

    private fun reduce(event: JokesEvent, jokeState: JokesViewState.Error) {
        when(event) { is JokesEvent.Reload -> reload(event.numberJokes) }
    }

    private fun reduce(event: JokesEvent, jokeState: JokesViewState.DisplayJoke) {
        when(event) {
            is JokesEvent.ChangeCountOfJoke -> changeCount(event.value, jokeState.jokes)
            is JokesEvent.Reload -> reload(event.numberJokes)
        }
    }

    private fun changeCount(value: String, jokes: List<String>) {
        viewModelScope.launch {
            _viewState.value = JokesViewState.DisplayJoke(jokes = jokes, countJokes = value)
        }
    }

    private fun reload(numberJokes: String) {
        useCase(numberJokes).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        _viewState.postValue(
                            JokesViewState.DisplayJoke(
                                jokes = result.data,
                                countJokes = ""
                            )
                        )
                    }
                }
                is Resource.Loading -> { _viewState.postValue(JokesViewState.Loading) }
                is Resource.Error -> { _viewState.postValue( JokesViewState.Error(
                    value = result.message ?: "An unexpected error occurred"))
                }
            }
        }.launchIn(viewModelScope)
    }
}