package ru.isaevsv.chuck_norris_api.core

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.isaevsv.chuck_norris_api.R

sealed class Screens(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val resourceId: Int,

    ) {
    object JokesScreens : Screens(
        route = "jokes_screens",
        resourceId = R.string.jokes,
        icon = R.drawable.buffoon
    )
    object WebScreens : Screens(
        route = "web_screens",
        resourceId = R.string.web,
        icon = R.drawable.web
    )
}
