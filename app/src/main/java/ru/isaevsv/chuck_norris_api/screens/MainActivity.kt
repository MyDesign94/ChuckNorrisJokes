package ru.isaevsv.chuck_norris_api.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.isaevsv.chuck_norris_api.screens.main_screen.MainScreen
import ru.isaevsv.chuck_norris_api.screens.ui.theme.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChuckNorrisApiTheme(
                style = NorrisStyle.Blue,
                darkTheme = false,
                textSize = NorrisSize.Medium,
                corners = NorrisCorners.Rounded,
                bigPaddingSize = NorrisSize.Medium,
                standardPaddingSize = NorrisSize.Medium,
                smallPaddingSize = NorrisSize.Medium,
                elevationSize = NorrisSize.Small
            ) {
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = blueDarkPalette.tintColor,
                        darkIcons = false
                    )
                }
                MainScreen()
            }
        }
    }
}
