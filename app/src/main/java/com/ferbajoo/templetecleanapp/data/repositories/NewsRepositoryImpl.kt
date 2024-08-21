package com.ferbajoo.templetecleanapp.data.repositories

import com.ferbajoo.templetecleanapp.data.mapper.RequestResult
import com.ferbajoo.templetecleanapp.data.mapper.toNewsModel
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import com.ferbajoo.templetecleanapp.utils.Constants.API_KEY
import com.ferbajoo.templetecleanapp.utils.getYesterdayDate
import com.ferbajoo.templetecleanapp.utils.safeApiCall
import javax.inject.Inject

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

    override suspend fun loadRecommendationNews(): RequestResult<List<ArticleModel>> {
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

    override suspend fun getNews(filter: String): RequestResult<NewsModel> {
        return safeApiCall {
            iNewsDataSource.getNews(filter, getYesterdayDate(), "publishedAt", 10, API_KEY)
                .toNewsModel()
        }
    }

}