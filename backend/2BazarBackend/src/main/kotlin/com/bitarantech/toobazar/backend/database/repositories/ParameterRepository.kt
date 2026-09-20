package com.bitarantech.toobazar.backend.database.repositories

import com.bitarantech.toobazar.backend.database.entities.ParameterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParameterRepository : JpaRepository<ParameterEntity, Long> {
    fun findAllByCategoryId(categoryId: Long): List<ParameterEntity>
}