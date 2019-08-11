package com.zabochen.doman.usecases

import com.zabochen.doman.common.ResultWrapper
import com.zabochen.doman.model.Advice
import com.zabochen.doman.repositories.AdviceRepository
import com.zabochen.doman.usecases.GetRandomAdviceUseCase.Params

class GetRandomAdviceUseCase(
    private val adviceRepository: AdviceRepository
) : UseCase<Params, ResultWrapper<Advice>>() {

    override suspend operator fun invoke(params: Params): ResultWrapper<Advice> {
        return adviceRepository.getRandomAdvice()
    }

    class Params
}