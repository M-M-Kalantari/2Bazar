package com.bitarantech.toobazar.backend.database.repositories

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocProvinceRepository: JpaRepository<LocProvinceEntity, Long> {

}