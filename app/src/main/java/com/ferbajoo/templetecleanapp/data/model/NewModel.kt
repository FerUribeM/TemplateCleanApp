package com.ferbajoo.templetecleanapp.data.model

import com.ferbajoo.templetecleanapp.data.remote.model.ArticlesResponse
import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse


data class NewsModel(
    val status: String? = "",
    val totalResults: Int? = 0,
    val articles: List<ArticleModel> = emptyList()
)

data class ArticleModel(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)