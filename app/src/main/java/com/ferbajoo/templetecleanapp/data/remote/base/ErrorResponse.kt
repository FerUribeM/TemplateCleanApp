package com.ferbajoo.templetecleanapp.data.remote.base

internal sealed class ErrorResponse {
    data class RequestError(
        val code: Int,
        val errorResponse: String
    ) : ErrorResponse()

    data object TimeoutError : ErrorResponse()
    data object NetworkError : ErrorResponse()
    data object UndefinedError : ErrorResponse()

}