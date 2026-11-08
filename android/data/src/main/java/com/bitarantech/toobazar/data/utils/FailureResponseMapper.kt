package com.bitarantech.toobazar.data.utils

import com.bitarantech.toobazar.domain.model.*
import com.bitarantech.toobazar.network.model.ApiResponseBody

fun ApiResponseBody<*>.toApiError(): ApiError {

    val errorMessage = message.fa.ifEmpty {
        message.en.ifEmpty {
            "An unknown error occurred."
        }
    }

    return when (this.httpStatus) {
        404 -> NotFoundError(httpStatus, errorMessage)
        401 -> UnauthorizedError(httpStatus, errorMessage)
        403 -> ForbiddenError(httpStatus, errorMessage)
        400 -> BadRequestError(httpStatus, errorMessage)
        409 -> ConflictError(httpStatus, errorMessage)
        410 -> GoneError(httpStatus, errorMessage)
        415 -> UnsupportedMediaTypeError(httpStatus, errorMessage)
        429 -> TooManyRequestsError(httpStatus, errorMessage)
        503 -> ServiceUnavailableError(httpStatus, errorMessage)
        500 -> ServerError(httpStatus, errorMessage)

        else -> object : ApiError {
            override val httpStatus = this@toApiError.httpStatus
            override val message = errorMessage
        }
    }
}