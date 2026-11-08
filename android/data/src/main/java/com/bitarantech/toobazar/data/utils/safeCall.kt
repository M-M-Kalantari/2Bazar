package com.bitarantech.toobazar.data.utils

import com.bitarantech.toobazar.domain.model.ApiError
import com.bitarantech.toobazar.domain.model.DataResult
import com.bitarantech.toobazar.domain.model.ServerError
import com.bitarantech.toobazar.network.model.ApiResponseBody
import com.bitarantech.toobazar.network.model.ApiResponseStatus
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import retrofit2.HttpException

suspend fun <T> safeCall(
    execute: suspend () -> ApiResponseBody<T>
): DataResult<T> {

    return try {

        val response = execute()

        if (response.status == ApiResponseStatus.SUCCESS) {

            val data = response.data

            if (data != null) {
                DataResult.Success(
                    data = data,
                    message = response.message.fa
                )
            } else {
                DataResult.Failure(
                    ServerError(
                        httpStatus = response.httpStatus,
                        message = "داده‌ای از سرور دریافت نشد."
                    )
                )
            }

        } else {
            DataResult.Failure(response.toApiError())
        }

    } catch (e: CancellationException) {
        throw e

    } catch (e: Exception) {
        DataResult.Failure(getApiError(e))
    }
}
fun getApiError(throwable: Throwable): ApiError {

    when (throwable) {

        is HttpException -> {

            val bodyError = throwable.response()
                ?.errorBody()
                ?.string()

            if (!bodyError.isNullOrBlank()) {

                val apiResponse = runCatching {
                    Json.decodeFromString<ApiResponseBody<JsonElement?>>(
                        bodyError
                    )
                }.getOrNull()

                if (apiResponse != null) {
                    return apiResponse.toApiError()
                }
            }

            return ServerError(
                httpStatus = throwable.code(),
                message = throwable.message()
            )
        }

        else -> {
            return object : ApiError {
                override val httpStatus = 598
                override val message =
                    throwable.message ?: "An unknown error occurred."
            }
        }
    }
}