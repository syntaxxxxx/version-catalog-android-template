package com.hightech.common.domain.oop

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<P, R : Any> constructor(private val dispatcher: CoroutineDispatcher) {

    abstract suspend fun buildFlowUseCase(param: P): Flow<R>

    suspend fun execute(params: P): Flow<R> {
        return buildFlowUseCase(params).flowOn(dispatcher)
    }

}

class ConnectivityException: Throwable()