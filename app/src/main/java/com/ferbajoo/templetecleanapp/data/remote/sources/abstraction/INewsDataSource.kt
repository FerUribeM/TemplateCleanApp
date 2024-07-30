package com.ferbajoo.templetecleanapp.data.remote.sources.abstraction

import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse

internal interface INewsDataSource {

    suspend fun breakingNews(): NewsModelResponse
    suspend fun breakingNews(category: String, pageSize: Int): NewsModelResponse

    suspend fun getNews(
        query: String,
        from: String,
        sort: String,
        pageSize: Int,
        language: String,
        apiKey: String
    ): NewsModelResponse

}