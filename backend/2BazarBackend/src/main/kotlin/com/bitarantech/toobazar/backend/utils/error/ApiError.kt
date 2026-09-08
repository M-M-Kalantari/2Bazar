package com.bitarantech.toobazar.backend.utils.error

import org.springframework.http.HttpStatus

data class ApiError(
    val status: HttpStatus,
    val code: String,
    val message: ErrorMessage
)
