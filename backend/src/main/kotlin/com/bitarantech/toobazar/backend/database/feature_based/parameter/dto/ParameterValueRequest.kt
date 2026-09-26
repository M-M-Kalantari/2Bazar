package com.bitarantech.toobazar.backend.database.feature_based.parameter.dto

import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterValueEntity

data class ParameterValueRequest(
    val value: String,
    val parameterId: Long
)

fun ParameterValueRequest.toEntity(ads: AdsEntity, parameter: ParameterEntity): ParameterValueEntity {
    return ParameterValueEntity(
        value = value,
        ads = ads,
        parameter = parameter
    )
}