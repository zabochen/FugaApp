package com.zabochen.fugaapp.di

import com.zabochen.data.AdviceRepositoryImpl
import com.zabochen.data.network.NetworkDataSource
import com.zabochen.doman.repositories.AdviceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAdviceRepository(networkDataSource: NetworkDataSource): AdviceRepository {
        return AdviceRepositoryImpl(networkDataSource)
    }
}