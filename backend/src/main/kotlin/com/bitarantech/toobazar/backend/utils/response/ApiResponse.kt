package com.bitarantech.toobazar.backend.utils.response

import com.bitarantech.toobazar.backend.utils.response.error.ApiException
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity

object ApiResponse {

    fun <T> success(
        success: ApiResponseInfo = Successes.SUC_200_OK.GENERAL,
        data: T? = null
    ): ResponseEntity<ApiResponseBody<T>> {

        return ResponseEntity
            .status(success.httpStatus)
            .body(
                ApiResponseBody(
                    status = ApiResponseStatus.SUCCESS,
                    httpStatus = success.httpStatus,
                    code = success.code,
                    message = success.message,
                    data = data
                )
            )
    }

    fun error(
        error: ApiResponseInfo
    ): Nothing {
        throw ApiException(error)
    }
}