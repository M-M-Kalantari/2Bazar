package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.other.ParameterDataType
import com.bitarantech.toobazar.backend.database.entities.ParameterEntity

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