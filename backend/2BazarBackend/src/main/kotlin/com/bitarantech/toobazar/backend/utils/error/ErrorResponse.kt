package com.bitarantech.toobazar.backend.utils.error

data class ErrorResponse(
    val status: Int,
    val code: String,
    val message: ErrorMessage
)