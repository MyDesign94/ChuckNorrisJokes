package ru.isaevsv.chuck_norris_api.screens.web_view_screen.model

import android.webkit.WebView

sealed class WebViewState {
    object Loading : WebViewState()
    data class DisplayWebView(val webView: WebView) : WebViewState()
}