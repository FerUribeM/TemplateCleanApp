package com.ferbajoo.templetecleanapp.domain.repository

import com.ferbajoo.templetecleanapp.data.mapper.RequestResult
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import kotlinx.coroutines.flow.Flow

internal interface INewsRepository {

    suspend fun getNews(): Flow<NewsModel>
    suspend fun loadRecommendationNews(): RequestResult<List<ArticleModel>>
    suspend fun loadBreakingNews(): RequestResult<NewsModel>

}