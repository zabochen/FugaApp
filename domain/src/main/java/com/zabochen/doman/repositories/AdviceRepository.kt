package com.zabochen.doman.repositories

import com.zabochen.doman.common.ResultWrapper
import com.zabochen.doman.model.Advice

interface AdviceRepository {
    suspend fun getRandomAdvice(): ResultWrapper<Advice>
}