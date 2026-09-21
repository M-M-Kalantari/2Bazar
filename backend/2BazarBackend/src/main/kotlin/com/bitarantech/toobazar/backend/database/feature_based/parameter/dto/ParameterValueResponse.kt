package com.bitarantech.toobazar.backend.database.feature_based.parameter.dto

import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterValueEntity

data class ParameterValueResponse(
    val value: String,
    val parameterResponse: ParameterResponse
)

fun ParameterValueEntity.toResponse(): ParameterValueResponse {
    return ParameterValueResponse(
        value = value,
        parameterResponse = parameter.toResponse()
    )
}