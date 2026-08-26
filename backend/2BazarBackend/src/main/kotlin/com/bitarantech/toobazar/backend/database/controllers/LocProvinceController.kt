package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.services.LocProvinceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LocProvinceController(
    val locProvinceService: LocProvinceService
) {

    @GetMapping("api/v1/loc_province")
    fun getProvinces(): List<LocProvinceEntity> = locProvinceService.findAll()

    @PostMapping("api/v1/loc_province")
    fun addProvince(
        @RequestParam name: String?
    ): String {
        return if (name.isNullOrEmpty()) {
            "Invalid Name"
        } else {
            locProvinceService.save(LocProvinceEntity(name = name))
            "Saved Successfully"
        }
    }

    @PostMapping("api/v1/loc_province")
    fun addProvincesList(
        @RequestParam name: String?
    ): String {
        return if (name.isNullOrEmpty()) {
            "Invalid Name"
        } else {
            locProvinceService.save(LocProvinceEntity(name = name))
            "Saved Successfully"
        }
    }

}