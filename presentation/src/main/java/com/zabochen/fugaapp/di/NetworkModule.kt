package com.zabochen.fugaapp.di

import com.zabochen.data.network.NetworkDataSource
import com.zabochen.data.network.NetworkDataSourceImpl
import com.zabochen.data.network.service.AdviceApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideAdviceApiService(): AdviceApiService {
        return AdviceApiService()
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(adviceApiService: AdviceApiService): NetworkDataSource {
        return NetworkDataSourceImpl(adviceApiService)
    }
}