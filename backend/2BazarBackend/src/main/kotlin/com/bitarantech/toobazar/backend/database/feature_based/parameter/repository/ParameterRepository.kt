package com.bitarantech.toobazar.backend.database.feature_based.parameter.repository

import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParameterRepository : JpaRepository<ParameterEntity, Long> {
    fun findAllByCategoryId(categoryId: Long): List<ParameterEntity>
    fun findAllByCategoryIdIn(categoryIds: List<Long>): List<ParameterEntity>
}