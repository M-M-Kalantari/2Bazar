package com.bitarantech.toobazar.backend.database.feature_based.location.dto

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocCityEntity

data class LocCityResponse(
    val id: Long,
    val name: String,
    val neighborhood: List<LocNeighborhoodResponse>? = null
)

fun LocCityEntity.toResponse(includeNeighborhoods: Boolean = true): LocCityResponse {
    return LocCityResponse(
        id = id,
        name = name,
        neighborhood = if (includeNeighborhoods) neighborhood.map { it.toResponse() } else null
    )
}