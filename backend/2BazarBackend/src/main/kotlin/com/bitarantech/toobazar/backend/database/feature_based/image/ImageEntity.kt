package com.bitarantech.toobazar.backend.database.feature_based.image

import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import jakarta.persistence.*

@Entity(name = "image")
data class ImageEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val path: String,

    @ManyToOne
    @JoinColumn(name = "ads_id")
    val ads: AdsEntity?
)