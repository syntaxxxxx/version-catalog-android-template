package com.hightech.common.result

sealed class NetworkClientResult<out T>(val value: T? = null, val throwable: Throwable? = null) {
    class Success<T>(data: T) : NetworkClientResult<T>(data)
    class Failure<T>(throwable: Throwable?) : NetworkClientResult<T>(throwable = throwable)
}

sealed class UiResult<out T>(val value: T? = null, val throwable: Throwable? = null) {
    class Success<T>(data: T) : UiResult<T>(data)
    class Failure<T>(throwable: Throwable?) : UiResult<T>(throwable = throwable)
}