package com.ferbajoo.templetecleanapp.domain.repository

import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import kotlinx.coroutines.flow.Flow

internal interface INewsRepository {

    suspend fun getNews(): Flow<NewsModel>
    suspend fun loadRecommendationNews(): Flow<List<ArticleModel>>
    suspend fun loadBreakingNews(): Flow<NewsModel>

}