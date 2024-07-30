package com.ferbajoo.templetecleanapp.presentation.base

import com.ferbajoo.templetecleanapp.data.remote.base.ErrorResponse
import java.io.IOException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import retrofit2.HttpException

internal fun <T> Flow<T>.handleErrors(
    onError: (ErrorResponse) -> Unit,
): Flow<T> {
    return catch { throwable ->
        val error = when (throwable) {
            is TimeoutCancellationException -> ErrorResponse.TimeoutError
            is IOException -> ErrorResponse.NetworkError
            is HttpException -> ErrorResponse.RequestError(throwable.code(), throwable.message())
            else -> ErrorResponse.UndefinedError
        }
        onError(error)
    }
}