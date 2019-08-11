package com.zabochen.data.network

import com.zabochen.data.network.model.random.RandomAdviceResponse
import retrofit2.Response

interface NetworkDataSource {

    suspend fun getRandomAdvice(): Response<RandomAdviceResponse>

}