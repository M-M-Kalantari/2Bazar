package com.bitarantech.toobazar.backend.utils.response

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponseBody<T>(
    val status: ApiResponseStatus,
    val httpStatus: HttpStatus,
    val code: String,
    val message: ApiResponseMessage,
    val data: T? = null,
)