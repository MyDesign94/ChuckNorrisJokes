package ru.isaevsv.chuck_norris_api.domain.repository

import ru.isaevsv.chuck_norris_api.data.remote.dto.ChuckJokeDto

interface ChuckRepository {

    suspend fun getJoke(count: Int): ChuckJokeDto
}