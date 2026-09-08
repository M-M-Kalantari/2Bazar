package com.bitarantech.toobazar.backend.utils.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ApiException::class)
    fun handleApiException(
        exception: ApiException
    ): ResponseEntity<ErrorResponse> {

        val error = exception.error

        return ResponseEntity
            .status(error.status)
            .body(
                ErrorResponse(
                    status = error.status.value(),
                    code = error.code,
                    message = error.message
                )
            )
    }
}