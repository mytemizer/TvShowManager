package com.example.tvshowmanager.model

import com.apollographql.apollo.api.Error

sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val error: List<com.apollographql.apollo.api.Error>) : ApiResult<Nothing>()
}