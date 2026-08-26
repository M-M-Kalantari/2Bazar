package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.repositories.LocProvinceRepository
import org.springframework.stereotype.Service

@Service
class LocProvinceService(
    val locProvinceRepository: LocProvinceRepository
) {

    fun findAll(): List<LocProvinceEntity> = locProvinceRepository.findAll()

    fun save(locProvinceEntity: LocProvinceEntity) : LocProvinceEntity {
        return locProvinceRepository.save(locProvinceEntity)
    }

}