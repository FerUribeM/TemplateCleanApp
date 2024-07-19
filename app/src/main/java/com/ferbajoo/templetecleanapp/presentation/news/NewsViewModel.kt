package com.ferbajoo.templetecleanapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferbajoo.templetecleanapp.domain.usecase.LoadNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class NewsViewModel @Inject constructor(
    private val loadNewsUseCase: LoadNewsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NewsViewState())
    val state = _state.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            loadNewsUseCase.invoke().onRight { news ->
                _state.update { it.copy(news = news, isLoading = false) }
            }.onLeft { error ->
                _state.update { it.copy(error = error.t?.message, isLoading = false) }
            }
        }
    }

}