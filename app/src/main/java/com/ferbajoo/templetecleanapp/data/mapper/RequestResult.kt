package com.ferbajoo.templetecleanapp.data.mapper

import com.ferbajoo.templetecleanapp.data.remote.base.ErrorResponse


internal sealed class RequestResult<out T> {

    data class Success<out T>(val data: T) : RequestResult<T>()
    data class RequestError(
        val error: ErrorResponse
    ) : RequestResult<Nothing>()

}