package com.ferbajoo.templetecleanapp.domain.repository

import arrow.core.Either
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.domain.model.NetworkError

internal interface INewsRepository {

    suspend fun getNews(): Either<NetworkError, NewsModel>

}