package com.bitarantech.toobazar.backend.database.feature_based.location.entity

import jakarta.persistence.*

@Entity(name = "province")
data class LocProvinceEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @OneToMany(mappedBy = "province")
    val city: List<LocCityEntity> = listOf(),
)