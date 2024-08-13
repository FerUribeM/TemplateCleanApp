package com.ferbajoo.templetecleanapp.data.repositories

import com.ferbajoo.templetecleanapp.data.mapper.RequestResult
import com.ferbajoo.templetecleanapp.data.mapper.toGeneralError
import com.ferbajoo.templetecleanapp.data.mapper.toNewsModel
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import com.ferbajoo.templetecleanapp.utils.Constants.API_KEY
import com.ferbajoo.templetecleanapp.utils.safeApiCall
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class NewsRepositoryImpl @Inject constructor(
    private val iNewsDataSource: INewsDataSource,
) : INewsRepository {

    override suspend fun loadBreakingNews(): RequestResult<NewsModel> {
        return safeApiCall {
            iNewsDataSource.breakingNews().toNewsModel()
        }
    }

    private suspend fun loadNewsByCategory(category: String, pageSize: Int): List<ArticleModel> {
        return iNewsDataSource.breakingNews(category, pageSize)
            .toNewsModel().articles.map { it.copy(category = category) }
    }

    override suspend fun loadRecommendationNews() : RequestResult<List<ArticleModel>> {
        return safeApiCall {
            val result = mutableListOf<ArticleModel>()
            val business = loadNewsByCategory("business", 2)
            val entertainment = loadNewsByCategory("entertainment", 2)
            val general = loadNewsByCategory("general", 2)
            val health = loadNewsByCategory("health", 2)
            val science = loadNewsByCategory("science", 2)
            val sports = loadNewsByCategory("sports", 2)
            val technology = loadNewsByCategory("technology", 2)
            result.apply {
                addAll(business)
                addAll(entertainment)
                addAll(general)
                addAll(health)
                addAll(science)
                addAll(sports)
                addAll(technology)
            }
            return@safeApiCall result
        }
    }

    override suspend fun getNews() = flow {
        try {
            emit(
                iNewsDataSource.getNews("sports", "2024-07-28", "publishedAt", 10, "es", API_KEY)
                    .toNewsModel()
            )
        } catch (e: Exception) {
            error(e.toGeneralError())
        }
    }

}