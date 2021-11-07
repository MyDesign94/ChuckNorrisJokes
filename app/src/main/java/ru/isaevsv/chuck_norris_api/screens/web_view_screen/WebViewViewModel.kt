package ru.isaevsv.chuck_norris_api.screens.web_view_screen

import android.webkit.WebView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.isaevsv.chuck_norris_api.core.EventHandler
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.model.WebViewEvent
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.model.WebViewState
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(
    private val webViewApi: WebView
): ViewModel(), EventHandler<WebViewEvent> {

    private val _viewState: MutableLiveData<WebViewState> = MutableLiveData(WebViewState.Loading)
    val viewState: LiveData<WebViewState> = _viewState
    override fun obtainEvent(event: WebViewEvent) {
        when(val currentState = _viewState.value){
            is WebViewState.Loading -> reduce(event, currentState)
        }
    }

    private fun reduce(event: WebViewEvent, currentState: WebViewState.Loading) {
        when(event) { is WebViewEvent.LoadingWebView -> loadingWebView() }
    }

    private fun loadingWebView() {
        viewModelScope.launch { _viewState.postValue(WebViewState.DisplayWebView(
            webView = webViewApi))
        }
    }
}