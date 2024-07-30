package com.ferbajoo.templetecleanapp.di

import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import com.ferbajoo.templetecleanapp.domain.usecase.LoadBreakingNewsUseCase
import com.ferbajoo.templetecleanapp.domain.usecase.LoadNewsUseCase
import com.ferbajoo.templetecleanapp.domain.usecase.LoadRecommendationNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object UsesCaseModule {

    @Provides
    fun provideLoadNewsUseCase(
        repository: INewsRepository
    ): LoadNewsUseCase {
        return LoadNewsUseCase(repository)
    }

    @Provides
    fun provideBreakingNewsUseCase(
        repository: INewsRepository
    ): LoadBreakingNewsUseCase {
        return LoadBreakingNewsUseCase(repository)
    }

    @Provides
    fun provideRecommendationUseCase(
        repository: INewsRepository
    ): LoadRecommendationNewsUseCase {
        return LoadRecommendationNewsUseCase(repository)
    }


}