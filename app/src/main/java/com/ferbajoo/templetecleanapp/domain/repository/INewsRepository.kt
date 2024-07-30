package com.ferbajoo.templetecleanapp.domain.repository

import arrow.core.Either
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.domain.model.NetworkError
import kotlinx.coroutines.flow.Flow

internal interface INewsRepository {

    suspend fun getNews(): Flow<NewsModel>
    suspend fun loadRecommendationNews(): Flow<List<ArticleModel>>
    suspend fun loadBreakingNews(): Flow<NewsModel>

}