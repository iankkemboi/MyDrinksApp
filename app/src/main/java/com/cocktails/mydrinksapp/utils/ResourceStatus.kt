package com.cocktails.mydrinksapp.utils

data class ResourceStatus<out T>(val status: StateStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): ResourceStatus<T> =
            ResourceStatus(status = StateStatus.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ResourceStatus<T> =
            ResourceStatus(status = StateStatus.ERROR, data = data, message = message)

        fun <T> loading(data: T?): ResourceStatus<T> =
            ResourceStatus(status = StateStatus.LOADING, data = data, message = null)
    }
}