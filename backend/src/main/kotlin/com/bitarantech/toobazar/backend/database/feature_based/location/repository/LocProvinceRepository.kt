package com.bitarantech.toobazar.backend.database.feature_based.location.repository

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocProvinceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocProvinceRepository : JpaRepository<LocProvinceEntity, Long> {}