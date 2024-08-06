package com.ferbajoo.templetecleanapp.data.remote.sources

import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse
import com.ferbajoo.templetecleanapp.data.remote.services.NewsService
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import com.ferbajoo.templetecleanapp.utils.Constants
import javax.inject.Inject
import javax.inject.Provider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext

internal class NewsDataSourceImpl @Inject constructor(
    private val newsService: Provider<NewsService>,
    private val ioDispatcher: CoroutineDispatcher
) : INewsDataSource {

    override suspend fun breakingNews(): NewsModelResponse {
        return withContext(ioDispatcher) {
            newsService.get().loadBreakingNews(apiKey = Constants.API_KEY)
        }
    }
    override suspend fun breakingNews(category: String, pageSize: Int): NewsModelResponse {
        return withContext(ioDispatcher) {
            newsService.get().loadBreakingNews(category = category, page = pageSize, apiKey = Constants.API_KEY)
        }
    }

    override suspend fun getNews(
        query: String,
        from: String,
        sort: String,
        pageSize: Int,
        language: String,
        apiKey: String
    ): NewsModelResponse {
        return withContext(ioDispatcher) {
            newsService.get().loadNews(query, from, sort, "10", "es", apiKey)
        }
    }

}