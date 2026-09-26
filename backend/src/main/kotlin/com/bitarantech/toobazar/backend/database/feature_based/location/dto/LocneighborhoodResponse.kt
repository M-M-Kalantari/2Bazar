package com.bitarantech.toobazar.backend.database.feature_based.location.dto

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity

data class LocNeighborhoodResponse(
    val id: Long,
    val name: String,
)

fun LocNeighborhoodEntity.toResponse(): LocNeighborhoodResponse = LocNeighborhoodResponse(id, name)