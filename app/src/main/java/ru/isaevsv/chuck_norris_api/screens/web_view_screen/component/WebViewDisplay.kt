package ru.isaevsv.chuck_norris_api.screens.web_view_screen.component

import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import ru.isaevsv.chuck_norris_api.screens.ui.theme.NorrisTheme

@Composable
fun WebViewDisplay(
    webView: WebView
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = NorrisTheme.colors.secondaryBackground
    ) {
        AndroidView(factory = { webView })
    }
}

