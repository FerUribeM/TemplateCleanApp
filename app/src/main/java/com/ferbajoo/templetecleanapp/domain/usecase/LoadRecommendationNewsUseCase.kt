package com.ferbajoo.templetecleanapp.domain.usecase

import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import javax.inject.Inject

internal class LoadRecommendationNewsUseCase @Inject constructor(
    private val newsRepository: INewsRepository
) {
    suspend operator fun invoke() = newsRepository.loadRecommendationNews()
}