package com.bitarantech.toobazar.backend.database.feature_based.parameter.entity

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import jakarta.persistence.*

@Entity(name = "parameters_value")
data class ParameterValueEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val value: String,

    @ManyToOne()
    @JoinColumn(name = "ads_id")
    val ads: AdsEntity,

    @ManyToOne()
    @JoinColumn(name = "parameter_id")
    val parameter: ParameterEntity,
)