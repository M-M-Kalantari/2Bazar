package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.entities.LocCityEntity
import com.bitarantech.toobazar.backend.database.services.LocCityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LocCityController(
    val service: LocCityService
) {

    @GetMapping("loc_city")
    fun getCities(): List<LocCityEntity> = service.findAll()



}