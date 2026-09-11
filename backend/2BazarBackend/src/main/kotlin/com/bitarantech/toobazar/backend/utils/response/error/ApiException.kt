package com.bitarantech.toobazar.backend.utils.response.error

import com.bitarantech.toobazar.backend.utils.response.ApiResponseInfo

class ApiException(
    val error: ApiResponseInfo
) : RuntimeException()