package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity

data class LocProvinceResponse(
    val id: Long,
    val name: String,
    val cities: List<LocCityResponse>? = null
)

fun LocProvinceEntity.toResponse(isFull: Boolean = true): LocProvinceResponse {
    return LocProvinceResponse(
        id = id,
        name = name,
        cities = if (isFull) city.map { it.toResponse() } else null
    )
}