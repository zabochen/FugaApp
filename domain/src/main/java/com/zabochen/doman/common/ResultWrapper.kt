package com.zabochen.doman.common

/**
 * A generic class that holds a value with loading status.
 */
sealed class ResultWrapper<out T> {

    object Loading : ResultWrapper<Nothing>()
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val exception: Exception) : ResultWrapper<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Loading -> "Loading"
            is Success<*> -> "Success [data=$data]"
            is Error -> "Error [exception=$exception]"
        }
    }
}