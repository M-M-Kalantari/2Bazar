package com.bitarantech.toobazar.backend.database.feature_based.location.entity

import jakarta.persistence.*

@Entity(name = "city")
data class LocCityEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ManyToOne()
    @JoinColumn(name = "province_id")
    val province: LocProvinceEntity,

    @OneToMany(mappedBy = "city")
    val neighborhood: List<LocNeighborhoodEntity> = listOf(),
)