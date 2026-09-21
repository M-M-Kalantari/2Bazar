package com.bitarantech.toobazar.backend.database.feature_based.location.service

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.repository.LocNeighborhoodRepository
import org.springframework.stereotype.Service

@Service
class LocNeighborhoodService(
    val repository: LocNeighborhoodRepository
) {

    fun findAll(): List<LocNeighborhoodEntity> = repository.findAll()

    fun save(entity: LocNeighborhoodEntity): LocNeighborhoodEntity = repository.save(entity)

    fun saveAll(entityList: List<LocNeighborhoodEntity>): List<LocNeighborhoodEntity?> = repository.saveAll(entityList)

    fun count(): Long = repository.count()

}