package ru.isaevsv.chuck_norris_api.screens.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class NorrisColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class NorrisTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class NorrisShape(
    val standardPadding: Dp,
    val bigPadding: Dp,
    val smallPadding: Dp,
    val elevation: Dp,
    val cornersStyle: Shape
)

data class NorrisImage(
    val mainIcon: Int,
    val mainIconDescription: String
)

object NorrisTheme {
    val colors: NorrisColors
        @Composable
        get() = LocalNorrisColors.current

    val typography: NorrisTypography
        @Composable
        get() = LocalNorrisTypography.current

    val shapes: NorrisShape
        @Composable
        get() = LocalNorrisShape.current

    val images: NorrisImage
        @Composable
        get() = LocalNorrisImage.current
}

enum class NorrisStyle {
    Purple, Orange, Blue, Red, Green
}

enum class NorrisSize {
    Small, Medium, Big
}

enum class NorrisCorners {
    Flat, Rounded
}

val LocalNorrisColors = staticCompositionLocalOf<NorrisColors> {
    error("No colors provided")
}

val LocalNorrisTypography = staticCompositionLocalOf<NorrisTypography> {
    error("No font provided")
}

val LocalNorrisShape = staticCompositionLocalOf<NorrisShape> {
    error("No shapes provided")
}

val LocalNorrisImage = staticCompositionLocalOf<NorrisImage> {
    error("No images provided")
}