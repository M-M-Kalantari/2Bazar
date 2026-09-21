package com.bitarantech.toobazar.backend.database.feature_based.parameter.dto

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryResponse
import com.bitarantech.toobazar.backend.database.feature_based.category.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.parameter.ParameterDataType
import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterEntity

data class ParameterResponse(
    val id: Long = 0,
    val name: String,
    val parameterDataType: ParameterDataType,
    val acceptedOption: List<String>? = null,
    val category: CategoryResponse?,
)

fun ParameterEntity.toResponse(includeCategories: Boolean = true): ParameterResponse {
    return ParameterResponse(
        id = id,
        name = name,
        parameterDataType = dataType,
        acceptedOption = acceptedOptions?.split(", ")?.map { it.trim() },
        category = if (includeCategories) category.toResponse() else null
    )
}