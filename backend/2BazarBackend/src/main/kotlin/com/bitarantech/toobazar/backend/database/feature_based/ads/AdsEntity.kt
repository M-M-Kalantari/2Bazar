package com.bitarantech.toobazar.backend.database.feature_based.ads

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import com.bitarantech.toobazar.backend.database.feature_based.image.ImageEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterValueEntity
import com.bitarantech.toobazar.backend.database.feature_based.user.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

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