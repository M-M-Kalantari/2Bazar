package com.bitarantech.toobazar.backend.utils.response

import org.springframework.http.HttpStatus

data class ApiResponseInfo(
    val httpStatus: HttpStatus,
    val code: String,
    val message: ApiResponseMessage
)
