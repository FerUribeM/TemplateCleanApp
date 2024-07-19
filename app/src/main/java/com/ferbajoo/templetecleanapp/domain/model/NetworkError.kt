package com.ferbajoo.templetecleanapp.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String) {
    NetworkError("Generic Error"),
    UnknownResponse("unknown Response"),
    UnknownError("unknown Error"),
}