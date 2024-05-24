package com.atom.andreytomilovtestandroidvacc2024.data.network

sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Failure(val exception: Throwable) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
}