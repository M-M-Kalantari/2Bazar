package com.bitarantech.toobazar.backend.database.feature_based.ads.dto

import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryResponse
import com.bitarantech.toobazar.backend.database.feature_based.category.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.image.ImageResponse
import com.bitarantech.toobazar.backend.database.feature_based.image.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.location.dto.LocNeighborhoodResponse
import com.bitarantech.toobazar.backend.database.feature_based.location.dto.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.parameter.dto.ParameterValueResponse
import com.bitarantech.toobazar.backend.database.feature_based.parameter.dto.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.user.dto.UserResponse
import com.bitarantech.toobazar.backend.database.feature_based.user.dto.toResponse
import java.time.Instant

data class AdsSummeryResponse(
    val id: Long,
    val title: String,
    val price: String,
    val location: LocNeighborhoodResponse,
    val previewImage: ImageResponse?,
    val created_at: Instant? = null,
)

fun AdsEntity.toSummeryResponse(): AdsSummeryResponse {
    return AdsSummeryResponse(
        id = id,
        title = title,
        price = price,
        location = location.toResponse(),
        previewImage = images.firstOrNull()?.toResponse(),
        created_at = created_at,
    )
}