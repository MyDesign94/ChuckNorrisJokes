package ru.isaevsv.chuck_norris_api.data.remote.dto

data class ChuckJokeDto(
    val type: String,
    val value: List<Value>
)