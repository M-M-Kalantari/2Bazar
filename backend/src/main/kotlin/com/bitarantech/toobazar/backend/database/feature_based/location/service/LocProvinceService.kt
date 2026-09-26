package com.bitarantech.toobazar.backend.database.feature_based.location.service

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.repository.LocProvinceRepository
import org.springframework.stereotype.Service

@Service
class LocProvinceService(
    val repository: LocProvinceRepository
) {

    fun findAll(): List<LocProvinceEntity> = repository.findAll()

    fun save(entity: LocProvinceEntity): LocProvinceEntity = repository.save(entity)

    fun saveAll(entityList: List<LocProvinceEntity>): List<LocProvinceEntity?> = repository.saveAll(entityList)

    fun count(): Long = repository.count()

}