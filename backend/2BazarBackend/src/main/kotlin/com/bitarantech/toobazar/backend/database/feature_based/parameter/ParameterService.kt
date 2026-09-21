package com.bitarantech.toobazar.backend.database.feature_based.parameter

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryService
import com.bitarantech.toobazar.backend.database.feature_based.parameter.entity.ParameterEntity
import org.springframework.stereotype.Service

@Service
class ParameterService(
    val repository: ParameterRepository,
    private val categoryService: CategoryService
) {

    fun findAll(): List<ParameterEntity> = repository.findAll()

    fun findByCategoryId(categoryId: Long): List<ParameterEntity> = repository.findAllByCategoryId(categoryId)

    fun findByCategoryIdWithParents(categoryId: Long): List<ParameterEntity>? {
        val category = categoryService.findById(categoryId) ?: return null

        val list = mutableListOf(categoryId)
        var currentCategory = category

        while (currentCategory.parent != null) {
            currentCategory = currentCategory.parent!!
            list.add(currentCategory.id)
        }

        return repository.findAllByCategoryIdIn(list)
    }

    fun save(entity: ParameterEntity): ParameterEntity = repository.save(entity)

    fun saveAll(entityList: List<ParameterEntity>): List<ParameterEntity?> = repository.saveAll(entityList)

    fun count(): Long = repository.count()

}