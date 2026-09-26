package com.bitarantech.toobazar.backend.database.feature_based.image

import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.dto.ParameterValueRequest
import com.bitarantech.toobazar.backend.database.feature_based.user.UserEntity

data class ImageResponse(
    val path: String,
)

fun ImageEntity.toResponse(): ImageResponse {
    return ImageResponse(
        path = path
    )
}