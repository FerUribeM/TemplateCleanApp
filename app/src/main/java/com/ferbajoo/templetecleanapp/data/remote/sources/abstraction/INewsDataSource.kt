package com.ferbajoo.templetecleanapp.data.remote.sources.abstraction

import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse

internal interface INewsDataSource {

    suspend fun getNews(
        query: String,
        from: String,
        sort: String,
        apiKey: String
    ): NewsModelResponse

}