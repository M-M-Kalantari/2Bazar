package com.bitarantech.toobazar.backend.database.feature_based.ads

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import com.bitarantech.toobazar.backend.database.feature_based.image.ImageEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterValueEntity
import com.bitarantech.toobazar.backend.database.feature_based.user.UserEntity
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

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
    val images: List<ImageEntity> = listOf(),

    @OneToMany(mappedBy = "ads")
    val parameterValue: List<ParameterValueEntity> = listOf(),

    @CreationTimestamp
    val created_at: Instant? = null,

    @UpdateTimestamp
    val updated_at: Instant? = null,
)