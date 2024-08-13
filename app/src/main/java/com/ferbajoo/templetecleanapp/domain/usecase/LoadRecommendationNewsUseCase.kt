package com.ferbajoo.templetecleanapp.domain.usecase

import com.ferbajoo.templetecleanapp.data.mapper.RequestResult
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import com.ferbajoo.templetecleanapp.presentation.base.HandlerStates
import com.ferbajoo.templetecleanapp.presentation.base.sendError
import com.ferbajoo.templetecleanapp.presentation.base.sendSuccess
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

internal class LoadRecommendationNewsUseCase @Inject constructor(
    private val newsRepository: INewsRepository
) {
    suspend operator fun invoke() = flow<HandlerStates<List<ArticleModel>>> {
        val result = newsRepository.loadRecommendationNews()
        when (result) {
            is RequestResult.RequestError -> sendError(result.error)
            is RequestResult.Success -> sendSuccess(result.data)
        }
    }
}