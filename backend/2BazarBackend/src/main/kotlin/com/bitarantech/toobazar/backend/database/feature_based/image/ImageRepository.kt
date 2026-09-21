package com.bitarantech.toobazar.backend.database.feature_based.image

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<ImageEntity, Long> {}