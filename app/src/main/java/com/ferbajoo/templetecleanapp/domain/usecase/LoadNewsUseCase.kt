package com.ferbajoo.templetecleanapp.domain.usecase

import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import javax.inject.Inject

internal class LoadNewsUseCase @Inject constructor(
    private val newsRepository: INewsRepository
) {
    suspend operator fun invoke() = newsRepository.getNews()
}