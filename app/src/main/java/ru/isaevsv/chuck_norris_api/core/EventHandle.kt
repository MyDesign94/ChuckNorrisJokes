package ru.isaevsv.chuck_norris_api.core

interface EventHandler<T> {
    fun obtainEvent(event: T)
}