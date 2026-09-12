package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity

data class LocProvinceResponse(
    val id: Long,
    val name: String,
    val cities: List<LocCityResponse>? = null
)

fun LocProvinceEntity.toResponse(includeCities: Boolean = true, includeNeighborhoods: Boolean = true): LocProvinceResponse {
    return LocProvinceResponse(
        id = id,
        name = name,
        cities = if (includeCities) city.map { it.toResponse(includeNeighborhoods = includeNeighborhoods) } else null
    )
}