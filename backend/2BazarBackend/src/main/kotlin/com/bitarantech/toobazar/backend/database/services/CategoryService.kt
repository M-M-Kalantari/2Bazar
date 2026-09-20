package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.CategoryEntity
import com.bitarantech.toobazar.backend.database.repositories.CategoryRepository
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@Service
class CategoryService(
    val repository: CategoryRepository
) {

    fun findAll(): List<CategoryEntity> = repository.findAll().filter { it.parent == null}

    fun findAllEntities(): List<CategoryEntity> { return repository.findAll() }

    fun findById(id: Long): CategoryEntity? = repository.findById(id).getOrNull()

    fun save(entity: CategoryEntity) : CategoryEntity = repository.save(entity)

    fun saveAll(entityList: List<CategoryEntity>) : List<CategoryEntity?> = repository.saveAll(entityList)

    fun count() : Long = repository.count()

}