package com.bitarantech.toobazar.backend.utils.error

class ApiException(
    val error: ApiError
) : RuntimeException()