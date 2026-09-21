package com.bitarantech.toobazar.backend.database.entities

import jakarta.persistence.*

@Entity(name = "ads")
data class AdsEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,

    val description: String,

    val price: String,

    @ManyToOne()
    @JoinColumn(name = "neighborhood_id")
    val location: LocNeighborhoodEntity,

    @ManyToOne()
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @ManyToOne()
    @JoinColumn(name = "category_id")
    val category: CategoryEntity,

    @OneToMany(mappedBy = "ads")
    val images: List<ImageEntity>,

    @OneToMany(mappedBy = "parameter_value")
    val parameterValue: List<ParameterValueEntity>,
)