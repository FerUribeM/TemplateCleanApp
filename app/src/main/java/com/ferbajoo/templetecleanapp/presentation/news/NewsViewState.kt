package com.ferbajoo.templetecleanapp.presentation.news

import com.ferbajoo.templetecleanapp.data.model.NewsModel

data class NewsViewState(
    val isLoading: Boolean = false,
    val news: NewsModel = NewsModel(),
    val error: String? = null
)