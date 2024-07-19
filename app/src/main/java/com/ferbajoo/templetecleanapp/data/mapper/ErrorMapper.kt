package com.ferbajoo.templetecleanapp.data.mapper

import com.ferbajoo.templetecleanapp.domain.model.ApiError
import com.ferbajoo.templetecleanapp.domain.model.NetworkError
import java.io.IOException
import retrofit2.HttpException

fun Throwable.toGeneralError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}