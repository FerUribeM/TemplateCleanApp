package com.ferbajoo.templetecleanapp.data.remote.base

internal sealed class ErrorResponse {
    data class RequestError(
        val code: Int,
        val errorResponse: String
    ) : ErrorResponse()

    object TimeoutError : ErrorResponse()
    object NetworkError : ErrorResponse()
    object UndefinedError : ErrorResponse()

}