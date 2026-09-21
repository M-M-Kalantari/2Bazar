package com.bitarantech.toobazar.backend.database.feature_based.ads

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdsRepository : JpaRepository<AdsEntity, Long> {}