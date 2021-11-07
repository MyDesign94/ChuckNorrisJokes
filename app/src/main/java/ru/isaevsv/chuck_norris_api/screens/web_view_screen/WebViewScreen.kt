package ru.isaevsv.chuck_norris_api.screens.web_view_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import ru.isaevsv.chuck_norris_api.screens.shered_screen.LoadingView
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.component.WebViewDisplay
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.model.WebViewEvent
import ru.isaevsv.chuck_norris_api.screens.web_view_screen.model.WebViewState

@Composable
fun WebScreen(viewModel: WebViewViewModel) {

    val currentWebViewState = viewModel.viewState.observeAsState()

    when(val state = currentWebViewState.value) {
        is WebViewState.Loading -> LoadingView()
        is WebViewState.DisplayWebView -> WebViewDisplay(webView = state.webView)
    }

    LaunchedEffect(key1 = Unit, block = { viewModel.obtainEvent(WebViewEvent.LoadingWebView) })
}