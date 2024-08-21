package com.ferbajoo.templetecleanapp.data.remote.services

import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse
import com.ferbajoo.templetecleanapp.utils.Constants.NEWS_ENDPOINT
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_API_KEY
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_CATEGORY
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_COUNTRY
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_FROM
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_LANGUAGE
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_PAGE
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_QUERY
import com.ferbajoo.templetecleanapp.utils.Constants.PARAM_SORT_BY
import com.ferbajoo.templetecleanapp.utils.Constants.TOP_HEADLINES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsService {

    @GET(TOP_HEADLINES)
    suspend fun loadBreakingNews(
        @Query(PARAM_COUNTRY) country: String = "us",
        @Query(PARAM_PAGE) page: Int = 30,
        @Query(PARAM_CATEGORY) category: String = "general",
        @Query(PARAM_API_KEY) apiKey: String
    ): NewsModelResponse

    @GET(NEWS_ENDPOINT)
    suspend fun loadNews(
        @Query(PARAM_QUERY) query: String,
        @Query(PARAM_FROM) from: String,
        @Query(PARAM_PAGE) page: Int,
        @Query(PARAM_LANGUAGE) language: String,
        @Query(PARAM_SORT_BY) sort: String,
        @Query(PARAM_API_KEY) apiKey: String
    ): NewsModelResponse

}