package com.bitarantech.toobazar.data.utils

import com.bitarantech.toobazar.domain.model.ApiError
import com.bitarantech.toobazar.domain.model.DataResult
import com.bitarantech.toobazar.domain.model.ServerError
import com.bitarantech.toobazar.network.model.FailureResponse
import com.bitarantech.toobazar.network.model.Status
import com.bitarantech.toobazar.network.model.SuccessResponse
import kotlinx.serialization.json.Json
import retrofit2.HttpException

suspend fun <T> safeCall(execute: suspend () -> SuccessResponse<T>): DataResult<T> {
    return try {
        val response = execute()
        if (response.status == Status.Success) {
            DataResult.Success(response.data!!, response.message)
        } else {
            DataResult.Failure(ServerError(504))
        }
    } catch (e: Throwable) {
        DataResult.Failure(getApiError(e))
    }
}

fun getApiError(throwable: Throwable): ApiError {
    when (throwable) {
        is HttpException -> {
            if (throwable.code() == 500) {
                return ServerError(500, message = throwable.message())
            }
            val bodyError = throwable.response()?.errorBody().toString()
            val failureResponse = Json.decodeFromString<FailureResponse>(bodyError)
            return failureResponse.toApiError()
        }

        else -> {
            return object : ApiError {
                override val httpStatus: Int = 598
                override val message: String = throwable.message ?: "An unknown error occurred."
            }
        }
    }
}