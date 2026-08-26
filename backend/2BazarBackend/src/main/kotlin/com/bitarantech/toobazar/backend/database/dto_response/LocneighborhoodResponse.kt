package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.LocNeighborhoodEntity

data class LocNeighborhoodResponse(
    val id: Long,
    val name: String,
)

fun LocNeighborhoodEntity.toResponse(): LocNeighborhoodResponse = LocNeighborhoodResponse(id, name)