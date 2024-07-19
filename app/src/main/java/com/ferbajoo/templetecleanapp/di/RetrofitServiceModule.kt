package com.ferbajoo.templetecleanapp.di

import com.ferbajoo.templetecleanapp.data.remote.services.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitServiceModule {

    @Provides
    fun provideNewsService(retrofit: Retrofit) = retrofit.create(NewsService::class.java)

}