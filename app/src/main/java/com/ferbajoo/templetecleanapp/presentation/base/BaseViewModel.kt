package com.ferbajoo.templetecleanapp.presentation.base

import androidx.lifecycle.ViewModel
import com.ferbajoo.templetecleanapp.presentation.news.NewsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal abstract class BaseViewModel<T : ViewState> : ViewModel() {

    @Suppress("PropertyName")
    protected abstract val _viewData: MutableStateFlow<T>

    val viewData: StateFlow<T>
        get() = _viewData
}