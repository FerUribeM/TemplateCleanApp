package com.ferbajoo.templetecleanapp.domain.repository

import com.ferbajoo.templetecleanapp.data.mapper.RequestResult
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel

internal interface INewsRepository {

    suspend fun getNews(filter: String): RequestResult<NewsModel>
    suspend fun loadRecommendationNews(): RequestResult<List<ArticleModel>>
    suspend fun loadBreakingNews(): RequestResult<NewsModel>

}