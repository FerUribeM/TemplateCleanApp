package com.ferbajoo.templetecleanapp.data.remote.services

import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse
import com.ferbajoo.templetecleanapp.utils.Constants.NEWS_ENDPOINT
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_API_KEY
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_FROM
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_QUERY
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_SORT_BY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsService {

    @GET(NEWS_ENDPOINT)
    suspend fun loadNews(
        @Query(PARAM_QUERY) query: String,
        @Query(PARAM_FROM) from: String,
        @Query(PARAM_SORT_BY) sort: String,
        @Query(PARAM_API_KEY) apiKey: String
    ): NewsModelResponse

}