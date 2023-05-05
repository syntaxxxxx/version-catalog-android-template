package com.hightech.common

import com.squareup.moshi.Json

data class BaseResponse<T>(
    @Json(name = "status_code") val statusCode: String?,
    @Json(name = "message") val message: String?,
    @Json(name = "data") val data: T
)