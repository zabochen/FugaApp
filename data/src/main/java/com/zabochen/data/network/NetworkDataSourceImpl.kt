package com.zabochen.data.network

import com.zabochen.data.network.model.random.RandomAdviceResponse
import com.zabochen.data.network.service.AdviceApiService
import retrofit2.Response

class NetworkDataSourceImpl(
    private val adviceApiService: AdviceApiService
) : NetworkDataSource {

    override suspend fun getRandomAdvice(): Response<RandomAdviceResponse> {
        return adviceApiService.getRandomAdvice()
    }
}