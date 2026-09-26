package com.bitarantech.toobazar.backend.database.feature_based.location.entity

import jakarta.persistence.*

@Entity(name = "neighborhood")
data class LocNeighborhoodEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ManyToOne()
    @JoinColumn(name = "city_id")
    val city: LocCityEntity,
)