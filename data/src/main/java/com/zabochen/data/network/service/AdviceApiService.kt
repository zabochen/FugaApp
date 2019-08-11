package com.zabochen.data.network.service

import com.zabochen.data.network.model.random.RandomAdviceResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://fucking-great-advice.ru/api/"

interface AdviceApiService {

    @GET("random")
    suspend fun getRandomAdvice(): Response<RandomAdviceResponse>

    companion object {
        operator fun invoke(): AdviceApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AdviceApiService::class.java)
        }
    }
}