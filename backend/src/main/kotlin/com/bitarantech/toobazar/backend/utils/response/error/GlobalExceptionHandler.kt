package com.bitarantech.toobazar.backend.utils.response.error

import com.bitarantech.toobazar.backend.utils.response.ApiResponseBody
import com.bitarantech.toobazar.backend.utils.response.ApiResponseStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApiException::class)
    fun handleApiException(
        exception: ApiException
    ): ResponseEntity<ApiResponseBody<Nothing>> {

        val error = exception.error

        return ResponseEntity
            .status(error.httpStatus)
            .body(
                ApiResponseBody(
                    status = ApiResponseStatus.ERROR,
                    httpStatus = error.httpStatus,
                    code = error.code,
                    message = error.message
                )
            )
    }
}