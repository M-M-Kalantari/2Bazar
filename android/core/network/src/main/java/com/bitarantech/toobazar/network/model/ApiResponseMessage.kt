package com.bitarantech.toobazar.network.model

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class ApiResponseMessage(
    val fa: String,
    val en: String
)