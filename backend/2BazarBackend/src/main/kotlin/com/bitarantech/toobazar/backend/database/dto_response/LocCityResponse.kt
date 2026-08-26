package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.LocCityEntity
import com.bitarantech.toobazar.backend.database.entities.LocNeighborhoodEntity

data class LocCityResponse(
    val id: Long,
    val name: String,
    val neighborhood: List<LocNeighborhoodResponse>? = null
)

fun LocCityEntity.toResponse(isFull: Boolean = true): LocCityResponse {
    return LocCityResponse(
        id = id,
        name = name,
        neighborhood = if (isFull) neighborhood.map { it.toResponse() } else null
    )
}