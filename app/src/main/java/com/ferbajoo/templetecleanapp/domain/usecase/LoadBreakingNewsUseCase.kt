package com.ferbajoo.templetecleanapp.domain.usecase

import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class LoadBreakingNewsUseCase @Inject constructor(
    private val newsRepository: INewsRepository
) {
    suspend operator fun invoke(): Flow<NewsModel> {
        return newsRepository.loadBreakingNews()
            .map { newsResponse ->
                NewsModel(
                    status = newsResponse.status,
                    totalResults = newsResponse.totalResults,
                    articles = newsResponse.articles.filter { it.urlToImage != null }
                )
            }
    }
}