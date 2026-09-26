package com.bitarantech.toobazar.backend.database.feature_based.parameter.service

import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterValueEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.repository.ParameterValueRepository
import org.springframework.stereotype.Service

@Service
class ParameterValueService(
    val repository: ParameterValueRepository,
) {

    fun findAll(): List<ParameterValueEntity> = repository.findAll()

    fun save(entity: ParameterValueEntity): ParameterValueEntity = repository.save(entity)

    fun saveAll(entityList: List<ParameterValueEntity>) = repository.saveAll(entityList)

    fun count(): Long = repository.count()

}