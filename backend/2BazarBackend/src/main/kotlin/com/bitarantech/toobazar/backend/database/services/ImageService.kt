package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.CategoryEntity
import com.bitarantech.toobazar.backend.database.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class ImageService(
    val repository: CategoryRepository
) {

    fun findAll(): List<CategoryEntity> = repository.findAll().filter { it.parent == null}

    fun save(entity: CategoryEntity) : CategoryEntity = repository.save(entity)

    fun saveAll(entityList: List<CategoryEntity>) : List<CategoryEntity?> = repository.saveAll(entityList)

    fun count() : Long = repository.count()

}