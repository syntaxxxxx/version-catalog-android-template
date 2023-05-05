package com.hightech.common.infra.remote

import com.hightech.common.NetworkClientException
import com.hightech.common.UnexpectedValuesRepresentation
import com.hightech.common.result.NetworkClientResult
import retrofit2.HttpException

suspend fun <T> execute(block: suspend () -> T): NetworkClientResult<T> {
    return try {
        NetworkClientResult.Success(block.invoke())
    } catch (throwable: Throwable) {
        if (throwable is HttpException) {
            /**
             * Handle http status code can reference to
             * https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses
             * */
            when (throwable.code()) {
                in 300..399 -> {
                    NetworkClientResult.Failure(NetworkClientException("Redirect"))
                }
                in 400..499 -> {
                    NetworkClientResult.Failure(NetworkClientException(throwable.response()?.message()))
                }
                in 500..599 -> {
                    NetworkClientResult.Failure(NetworkClientException("Server Error"))
                }
                else -> {
                    NetworkClientResult.Failure(UnexpectedValuesRepresentation())
                }
            }
        } else {
            NetworkClientResult.Failure(throwable)
        }
    }
}