package com.ferbajoo.templetecleanapp.di

import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import com.ferbajoo.templetecleanapp.domain.usecase.LoadNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object UsesCaseModule {

    @Provides
    fun provideGetUserUseCase(
        repository: INewsRepository
    ): LoadNewsUseCase {
        return LoadNewsUseCase(repository)
    }

}