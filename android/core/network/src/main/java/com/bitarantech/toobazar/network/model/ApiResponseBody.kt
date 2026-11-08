package com.bitarantech.toobazar.network.model


data class ApiResponseBody<T>(
    val status: ApiResponseStatus,
    val httpStatus: Int,
    val code: String,
    val message: ApiResponseMessage,
    val data: T? = null,
)