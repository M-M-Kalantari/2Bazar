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

data class AdsResponse(
    val id: Long? = 0,
    val title: String,
    val description: String,
    val price: String,
    val location: LocNeighborhoodResponse,
    val user: UserResponse,
    val category: CategoryResponse,
    val image: List<ImageResponse>,
    val parameterValues: List<ParameterValueResponse>,
)

fun AdsEntity.toResponse(): AdsResponse {
    return AdsResponse(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        location = location.toResponse(),
        user = user.toResponse(""),
        category = category.toResponse(),
        image = images.map { image -> image.toResponse() },
        parameterValues = parameterValue.map { parameter -> parameter.toResponse() }
    )
}