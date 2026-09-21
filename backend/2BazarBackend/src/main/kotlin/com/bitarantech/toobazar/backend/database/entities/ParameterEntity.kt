package com.bitarantech.toobazar.backend.database.entities

import com.bitarantech.toobazar.backend.database.other.ParameterDataType
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