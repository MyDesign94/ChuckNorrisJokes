package ru.isaevsv.chuck_norris_api.data.remote.dto

data class Value(
    val categories: List<String>,
    val id: Int,
    val joke: String
)