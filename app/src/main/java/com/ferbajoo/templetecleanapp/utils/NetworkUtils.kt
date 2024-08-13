package com.ferbajoo.templetecleanapp.utils

import com.ferbajoo.templetecleanapp.data.mapper.RequestResult
import com.ferbajoo.templetecleanapp.data.remote.base.ErrorResponse
import java.io.IOException
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException

internal suspend fun <T> safeApiCall(apiCall: suspend () -> T): RequestResult<T> {
    return try {
        val result = apiCall.invoke()
        RequestResult.Success(result)
    } catch (throwable: Exception) {
        return when (throwable) {
            is TimeoutCancellationException -> RequestResult.RequestError(ErrorResponse.TimeoutError)
            is IOException -> RequestResult.RequestError(ErrorResponse.NetworkError)
            is HttpException -> RequestResult.RequestError(
                ErrorResponse.RequestError(
                    throwable.code(),
                    throwable.message()
                )
            )
            else -> RequestResult.RequestError(ErrorResponse.UndefinedError)
        }
    }
}