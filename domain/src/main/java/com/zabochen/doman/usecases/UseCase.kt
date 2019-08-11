package com.zabochen.doman.usecases

abstract class UseCase<in Params, out TypeResult> where TypeResult : Any {

    abstract suspend operator fun invoke(params: Params): TypeResult

}