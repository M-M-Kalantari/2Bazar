package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.LocCityEntity
import com.bitarantech.toobazar.backend.database.repositories.LocCityRepository
import org.springframework.stereotype.Service

@Service
class LocCityService(
    val repository: LocCityRepository
) {

    fun findAll(): List<LocCityEntity> = repository.findAll()

    fun save(entity: LocCityEntity) : LocCityEntity = repository.save(entity)

    fun saveAll(entityList: List<LocCityEntity>) : List<LocCityEntity?> = repository.saveAll(entityList)

    fun count() : Long = repository.count()

}