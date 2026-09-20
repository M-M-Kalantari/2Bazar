package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.ParameterEntity
import com.bitarantech.toobazar.backend.database.repositories.ParameterRepository
import org.springframework.stereotype.Service

@Service
class ParameterService(
    val repository: ParameterRepository
) {

    fun findAll(): List<ParameterEntity> = repository.findAll()

    fun findByCategory(categoryId: Long): List<ParameterEntity> = repository.findAllByCategoryId(categoryId)

    fun save(entity: ParameterEntity) : ParameterEntity = repository.save(entity)

    fun saveAll(entityList: List<ParameterEntity>) : List<ParameterEntity?> = repository.saveAll(entityList)

    fun count() : Long = repository.count()

}