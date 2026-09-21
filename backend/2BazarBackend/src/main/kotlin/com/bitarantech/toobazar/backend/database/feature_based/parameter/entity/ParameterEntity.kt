package com.bitarantech.toobazar.backend.database.feature_based.parameter.entity

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.ParameterDataType
import jakarta.persistence.*

@Entity(name = "parameters")
data class ParameterEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val dataType: ParameterDataType,

    val acceptedOptions: String? = null,

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = true)
    val category: CategoryEntity,
)