package com.ferbajoo.templetecleanapp.presentation.news

import androidx.lifecycle.viewModelScope
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.data.remote.base.ErrorResponse
import com.ferbajoo.templetecleanapp.domain.usecase.LoadBreakingNewsUseCase
import com.ferbajoo.templetecleanapp.domain.usecase.LoadRecommendationNewsUseCase
import com.ferbajoo.templetecleanapp.presentation.base.BaseViewModel
import com.ferbajoo.templetecleanapp.presentation.base.handleErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
internal class NewsViewModel @Inject constructor(
    private val breakingNewsUseCase: LoadBreakingNewsUseCase,
    private val recommendationNewsUseCase: LoadRecommendationNewsUseCase
) : BaseViewModel<NewsViewState>() {

    override val _viewData = MutableStateFlow(NewsViewState.Idle)

    init {
        loadBreakingNews()
    }

    private fun loadBreakingNews() {
        viewModelScope.launch {
            _viewData.value = NewsViewState.Loading
            breakingNewsUseCase.invoke()
                .collect { state ->
                    state.error?.let {
                        if (it is ErrorResponse.RequestError) {
                            _viewData.value = NewsViewState.Idle
                        }
                    }
                    state.success?.let {
                        loadRecommendationNews(it)
                    }
                }
        }
    }

    private fun loadRecommendationNews(news: NewsModel) {
        viewModelScope.launch {
            _viewData.value = NewsViewState.Loading
            recommendationNewsUseCase.invoke()
                .collect { state ->
                    state.error?.let {
                        _viewData.value = NewsViewState.Idle
                    }
                    state.success?.let { recommendations ->
                        _viewData.value = _viewData.value.copy(
                            recommendationNews = recommendations,
                            breakingNews = news
                        )
                    }
                }
        }
    }

}