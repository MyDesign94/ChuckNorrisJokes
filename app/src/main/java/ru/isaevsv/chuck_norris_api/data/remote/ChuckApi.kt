package ru.isaevsv.chuck_norris_api.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.isaevsv.chuck_norris_api.core.Constants.PREFIX
import ru.isaevsv.chuck_norris_api.data.remote.dto.ChuckJokeDto

interface ChuckApi {

    @GET(PREFIX)
    suspend fun getJokes(@Path("count") count:Int): ChuckJokeDto
}