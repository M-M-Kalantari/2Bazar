package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.repositories.LocProvinceRepository
import org.springframework.stereotype.Service

@Service
class LocProvinceService(
    val repository: LocProvinceRepository
) {

    fun findAll(): List<LocProvinceEntity> = repository.findAll()

    fun save(entity: LocProvinceEntity) : LocProvinceEntity = repository.save(entity)

    fun saveAll(entityList: List<LocProvinceEntity>) : List<LocProvinceEntity?> = repository.saveAll(entityList)

    fun count() : Long = repository.count()

}