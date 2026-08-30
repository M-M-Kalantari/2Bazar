package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.CategoryEntity
import com.bitarantech.toobazar.backend.database.entities.LocNeighborhoodEntity

data class CategoryResponse(
    val id: Long,
    val name: String,
    val icon: String,
    val children: List<CategoryResponse>,
)

fun CategoryEntity.toResponse(): CategoryResponse {
    return CategoryResponse(
        id = id,
        name = name,
        icon = icon,
        children = children.map { it.toResponse() }
    )
}