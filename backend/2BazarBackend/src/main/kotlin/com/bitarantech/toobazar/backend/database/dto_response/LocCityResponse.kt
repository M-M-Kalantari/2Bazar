package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.LocCityEntity

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