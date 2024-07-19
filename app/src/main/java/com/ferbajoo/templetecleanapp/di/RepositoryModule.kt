package com.ferbajoo.templetecleanapp.di

import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import com.ferbajoo.templetecleanapp.data.repositories.NewsRepositoryImpl
import com.ferbajoo.templetecleanapp.domain.repository.INewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    fun providerNewsRepository(
        newsDataSource: INewsDataSource
    ): INewsRepository = NewsRepositoryImpl(newsDataSource)

}