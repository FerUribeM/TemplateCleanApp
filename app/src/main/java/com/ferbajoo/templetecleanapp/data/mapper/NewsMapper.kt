package com.ferbajoo.templetecleanapp.data.mapper

import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.data.remote.model.ArticlesResponse
import com.ferbajoo.templetecleanapp.data.remote.model.NewsModelResponse

fun NewsModelResponse.toNewsModel(): NewsModel {
    return NewsModel(
        status = status,
        totalResults = totalResults,
        articles = articles.map { it.toArticleModel() }
    )
}

fun ArticlesResponse.toArticleModel(): ArticleModel {
    return ArticleModel(
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content,
        category = ""
    )
}