package com.bitarantech.toobazar.backend.database.feature_based.location.service

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocNeighborhoodEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.repository.LocNeighborhoodRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class LocNeighborhoodService(
    val repository: LocNeighborhoodRepository
) {

    fun findAll(): List<LocNeighborhoodEntity> = repository.findAll()

    fun findById(id: Long): LocNeighborhoodEntity? = repository.findById(id).getOrNull()

    fun getReferenceById(id: Long): LocNeighborhoodEntity? {
        return try {
            repository.getReferenceById(id)
        } catch (e: Exception){
            null
        }
    }

    fun save(entity: LocNeighborhoodEntity): LocNeighborhoodEntity = repository.save(entity)

    fun saveAll(entityList: List<LocNeighborhoodEntity>): List<LocNeighborhoodEntity?> = repository.saveAll(entityList)

    fun count(): Long = repository.count()

}