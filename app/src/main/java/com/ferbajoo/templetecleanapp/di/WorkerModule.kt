package com.ferbajoo.templetecleanapp.di

import com.ferbajoo.templetecleanapp.data.remote.services.NewsService
import com.ferbajoo.templetecleanapp.data.remote.sources.NewsDataSourceImpl
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider

@Module
@InstallIn(SingletonComponent::class)
internal object WorkerModule {

    @Provides
    fun provideNewsDataSource(newsService: Provider<NewsService>): INewsDataSource {
        return NewsDataSourceImpl(newsService)
    }

}