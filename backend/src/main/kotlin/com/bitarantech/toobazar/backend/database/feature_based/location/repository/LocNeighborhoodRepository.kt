package com.bitarantech.toobazar.backend.database.feature_based.location.repository

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocNeighborhoodRepository : JpaRepository<LocNeighborhoodEntity, Long> {}