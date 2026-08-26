package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.services.LocProvinceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LocProvinceController(
    val service: LocProvinceService
) {

    @GetMapping("loc_province")
    fun getProvinces(): List<LocProvinceEntity> = service.findAll()

    @PostMapping("loc_province")
    fun addProvince(
        @RequestParam name: String?
    ): String {
        return if (name.isNullOrEmpty()) {
            "Invalid Name"
        } else {
            service.save(LocProvinceEntity(name = name))
            "Saved Successfully"
        }
    }

}