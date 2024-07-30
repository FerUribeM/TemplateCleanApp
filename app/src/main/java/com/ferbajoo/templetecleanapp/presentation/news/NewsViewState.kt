package com.ferbajoo.templetecleanapp.presentation.news

import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.data.remote.base.ErrorResponse
import com.ferbajoo.templetecleanapp.presentation.base.ViewState

internal data class NewsViewState(
    val breakingNews: NewsModel = NewsModel(),
    val recommendationNews: List<ArticleModel> = emptyList(),
    val error: ErrorResponse? = null
) : ViewState {
    companion object {
        val Idle = NewsViewState()
        val Loading = NewsViewState()
        val ErrorState = NewsViewState()
    }
}