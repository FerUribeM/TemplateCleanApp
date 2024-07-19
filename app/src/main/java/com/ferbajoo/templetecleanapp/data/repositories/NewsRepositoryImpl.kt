package com.ferbajoo.templetecleanapp.data.repositories

import arrow.core.Either
import com.ferbajoo.templetecleanapp.data.mapper.toGeneralError
import com.ferbajoo.templetecleanapp.data.mapper.toNewsModel
import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import com.ferbajoo.templetecleanapp.domain.model.NetworkError
import com.ferbajoo.templetecleanapp.utils.Constants.API_KEY
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(
    private val iNewsDataSource: INewsDataSource,
) : INewsRepository {

    override suspend fun getNews(): Either<NetworkError, NewsModel> {
        return Either.catch {
            iNewsDataSource.getNews("sports", "2024-06-19", "publishedAt", API_KEY)
        }.map {
            it.toNewsModel()
        }.mapLeft {
            it.toGeneralError()
        }
    }

}