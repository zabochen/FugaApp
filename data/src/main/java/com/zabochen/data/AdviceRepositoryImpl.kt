package com.zabochen.data

import com.zabochen.data.network.NetworkDataSource
import com.zabochen.data.network.model.random.RandomAdviceResponse
import com.zabochen.doman.common.ResultWrapper
import com.zabochen.doman.common.ResultWrapper.Error
import com.zabochen.doman.common.ResultWrapper.Success
import com.zabochen.doman.model.Advice
import com.zabochen.doman.repositories.AdviceRepository

class AdviceRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : AdviceRepository {

    override suspend fun getRandomAdvice(): ResultWrapper<Advice> {
        return try {
            val randomAdviceResponse: RandomAdviceResponse = networkDataSource.getRandomAdvice().body()!!
            val randomAdvice: Advice = with(randomAdviceResponse) {
                Advice(id = this.id, text = this.text)
            }
            Success(randomAdvice)
        } catch (e: Exception) {
            Error(e)
        }
    }
}