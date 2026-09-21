package com.bitarantech.toobazar.backend.database.feature_based.ads.dto

import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.dto.ParameterValueRequest
import com.bitarantech.toobazar.backend.database.feature_based.user.UserEntity

data class AdsRequest(
    val id: Long? = 0,
    val title: String,
    val description: String,
    val price: String,
    val locationId: Long,
    val categoryId: Long,
    val parameterValues: List<ParameterValueRequest>,
)

fun AdsRequest.toEntity(location: LocNeighborhoodEntity, category: CategoryEntity, user: UserEntity): AdsEntity {
    return AdsEntity(
        id = id ?: 0L,
        title = title,
        description = description,
        price = price,
        location = location,
        category = category,
        user = user,
    )
}