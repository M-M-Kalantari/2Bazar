package com.bitarantech.toobazar.backend.database.feature_based.parameter.repository

import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterValueEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParameterValueRepository : JpaRepository<ParameterValueEntity, Long> {}