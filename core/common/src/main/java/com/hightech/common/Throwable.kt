package com.hightech.common

data class NetworkClientException(override val message: String? = null): Throwable()
class UnexpectedValuesRepresentation: Throwable()