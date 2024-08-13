package com.ferbajoo.templetecleanapp.presentation.base

import com.ferbajoo.templetecleanapp.data.remote.base.ErrorResponse
import kotlinx.coroutines.flow.FlowCollector

internal data class HandlerStates<T>(
    val success: T? = null,
    val error: ErrorResponse? = null
) : ViewState

internal suspend fun <T> FlowCollector<HandlerStates<T>>.sendSuccess(data: T) = emit(HandlerStates(success = data))
internal suspend fun <T> FlowCollector<HandlerStates<T>>.sendError(error: ErrorResponse) = emit(HandlerStates(error = error))