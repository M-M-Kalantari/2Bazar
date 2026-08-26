package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_response.LocCityResponse
import com.bitarantech.toobazar.backend.database.dto_response.LocProvinceResponse
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.services.LocProvinceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LocationController(
    val service: LocProvinceService
) {

    @GetMapping("location")
    fun getProvinces(): List<LocProvinceResponse> = service.findAll().map { it.toResponse() }

}