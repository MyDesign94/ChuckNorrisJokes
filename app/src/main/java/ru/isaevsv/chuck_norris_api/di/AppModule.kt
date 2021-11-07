package ru.isaevsv.chuck_norris_api.di

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.isaevsv.chuck_norris_api.core.Constants
import ru.isaevsv.chuck_norris_api.core.Constants.BASE_URL
import ru.isaevsv.chuck_norris_api.data.remote.ChuckApi
import ru.isaevsv.chuck_norris_api.data.repository.ChuckRepositoryImpl
import ru.isaevsv.chuck_norris_api.domain.repository.ChuckRepository
import ru.isaevsv.chuck_norris_api.domain.use_case.GetJokeUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideChuckApi(): ChuckApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ChuckApi::class.java)
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Provides
    @Singleton
    fun provideWebView(@ApplicationContext context: Context): WebView {
        return WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.loadWithOverviewMode= true
            settings.javaScriptEnabled = true
            settings.useWideViewPort = true
            settings.domStorageEnabled = true
            settings.loadsImagesAutomatically
            settings.builtInZoomControls = true
            settings.displayZoomControls = false
            webViewClient = WebViewClient()
            loadUrl(Constants.WEB_VIEW_URL)
        }
    }

    @Provides
    @Singleton
    fun provideChuckRepository(api: ChuckApi): ChuckRepository {
        return ChuckRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideChuckUseCase(repository: ChuckRepository): GetJokeUseCase {
        return GetJokeUseCase(repository = repository)
    }
}