package com.bitarantech.toobazar.backend.database.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "parameters_value")
data class ParameterValueEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val value: String,

    @ManyToOne()
    @JoinColumn(name = "ads_id", nullable = true)
    val ads: AdsEntity,

    @ManyToOne()
    @JoinColumn(name = "parameter_id", nullable = true)
    val parameter: ParameterEntity,

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = true)
    val category: CategoryEntity?,
)