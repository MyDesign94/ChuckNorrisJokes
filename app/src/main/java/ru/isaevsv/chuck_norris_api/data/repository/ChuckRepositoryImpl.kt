package ru.isaevsv.chuck_norris_api.data.repository

import ru.isaevsv.chuck_norris_api.data.remote.ChuckApi
import ru.isaevsv.chuck_norris_api.data.remote.dto.ChuckJokeDto
import ru.isaevsv.chuck_norris_api.domain.repository.ChuckRepository
import javax.inject.Inject

class ChuckRepositoryImpl @Inject constructor(
    private val api: ChuckApi
): ChuckRepository {

    override suspend fun getJoke(count: Int): ChuckJokeDto {
        return api.getJokes(count = count)
    }
}