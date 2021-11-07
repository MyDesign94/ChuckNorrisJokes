package ru.isaevsv.chuck_norris_api.screens.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.isaevsv.chuck_norris_api.R

@Composable
fun ChuckNorrisApiTheme(
    style: NorrisStyle = NorrisStyle.Purple,
    textSize: NorrisSize = NorrisSize.Medium,
    elevationSize: NorrisSize = NorrisSize.Medium,
    standardPaddingSize: NorrisSize = NorrisSize.Medium,
    bigPaddingSize: NorrisSize = NorrisSize.Medium,
    smallPaddingSize: NorrisSize = NorrisSize.Medium,
    corners: NorrisCorners = NorrisCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                NorrisStyle.Purple -> purpleDarkPalette
                NorrisStyle.Blue -> blueDarkPalette
                NorrisStyle.Orange -> orangeDarkPalette
                NorrisStyle.Red -> redDarkPalette
                NorrisStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                NorrisStyle.Purple -> purpleLightPalette
                NorrisStyle.Blue -> blueLightPalette
                NorrisStyle.Orange -> orangeLightPalette
                NorrisStyle.Red -> redLightPalette
                NorrisStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = NorrisTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                NorrisSize.Small -> 24.sp
                NorrisSize.Medium -> 28.sp
                NorrisSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                NorrisSize.Small -> 14.sp
                NorrisSize.Medium -> 16.sp
                NorrisSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                NorrisSize.Small -> 14.sp
                NorrisSize.Medium -> 20.sp
                NorrisSize.Big -> 24.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                NorrisSize.Small -> 10.sp
                NorrisSize.Medium -> 12.sp
                NorrisSize.Big -> 14.sp
            }
        )
    )

    val shapes = NorrisShape(
        bigPadding = when (bigPaddingSize) {
            NorrisSize.Small -> 20.dp
            NorrisSize.Medium -> 24.dp
            NorrisSize.Big -> 28.dp
        },
        standardPadding = when (standardPaddingSize) {
            NorrisSize.Small -> 12.dp
            NorrisSize.Medium -> 16.dp
            NorrisSize.Big -> 20.dp
        },
        smallPadding = when (smallPaddingSize) {
            NorrisSize.Small -> 3.dp
            NorrisSize.Medium -> 6.dp
            NorrisSize.Big -> 9.dp
        },
        elevation = when (elevationSize) {
            NorrisSize.Small -> 2.dp
            NorrisSize.Medium -> 4.dp
            NorrisSize.Big -> 6.dp
        },
        cornersStyle = when (corners) {
            NorrisCorners.Flat -> RoundedCornerShape(0.dp)
            NorrisCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    val images = NorrisImage(
        mainIcon = if (darkTheme) R.drawable.ic_baseline_mood_24 else R.drawable.ic_baseline_mood_bad_24,
        mainIconDescription = if (darkTheme) "Good Mood" else "Bad Mood"
    )

    CompositionLocalProvider(
        LocalNorrisColors provides colors,
        LocalNorrisTypography provides typography,
        LocalNorrisShape provides shapes,
        LocalNorrisImage provides images,
        content = content
    )
}