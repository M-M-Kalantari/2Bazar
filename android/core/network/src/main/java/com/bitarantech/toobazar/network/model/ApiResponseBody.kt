package com.bitarantech.toobazar.network.model

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class ApiResponseBody<T>(
    val status: ApiResponseStatus,
    val httpStatus: Int,
    val code: String,
    val message: ApiResponseMessage,
    val data: T? = null,
)