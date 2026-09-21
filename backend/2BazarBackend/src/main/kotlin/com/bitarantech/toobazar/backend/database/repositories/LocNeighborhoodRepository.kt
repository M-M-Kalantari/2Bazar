package com.bitarantech.toobazar.backend.database.repositories

import com.bitarantech.toobazar.backend.database.entities.LocNeighborhoodEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocNeighborhoodRepository : JpaRepository<LocNeighborhoodEntity, Long> {}