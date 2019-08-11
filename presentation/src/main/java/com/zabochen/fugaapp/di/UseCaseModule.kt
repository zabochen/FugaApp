package com.zabochen.fugaapp.di

import com.zabochen.doman.repositories.AdviceRepository
import com.zabochen.doman.usecases.GetRandomAdviceUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepositoryModule::class])
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetRandomAdviceUseCase(adviceRepository: AdviceRepository): GetRandomAdviceUseCase {
        return GetRandomAdviceUseCase(adviceRepository)
    }
}