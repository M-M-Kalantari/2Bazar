package com.bitarantech.toobazar.network.model

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
enum class ApiResponseStatus {
    SUCCESS,
    ERROR
}