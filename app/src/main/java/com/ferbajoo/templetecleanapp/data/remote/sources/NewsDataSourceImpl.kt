package com.ferbajoo.templetecleanapp.data.remote.sources

import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse
import com.ferbajoo.templetecleanapp.data.remote.services.NewsService
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import javax.inject.Inject
import javax.inject.Provider

internal class NewsDataSourceImpl @Inject constructor(
    private val newsService: Provider<NewsService>
) : INewsDataSource {

    override suspend fun getNews(
        query: String,
        from: String,
        sort: String,
        apiKey: String
    ): NewsModelResponse {
        return newsService.get().loadNews(query, from, sort, apiKey)
    }

}