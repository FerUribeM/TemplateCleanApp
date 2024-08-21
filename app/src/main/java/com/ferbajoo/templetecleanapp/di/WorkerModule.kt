package com.ferbajoo.templetecleanapp.di

import android.content.Context
import com.ferbajoo.templetecleanapp.data.remote.services.NewsService
import com.ferbajoo.templetecleanapp.data.remote.sources.NewsDataSourceImpl
import com.ferbajoo.templetecleanapp.data.remote.sources.abstraction.INewsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
internal object WorkerModule {

    @Provides
    fun provideNewsDataSource(
        newsService: Provider<NewsService>,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        @ApplicationContext context: Context
    ): INewsDataSource {
        return NewsDataSourceImpl(newsService, ioDispatcher, context)
    }

}