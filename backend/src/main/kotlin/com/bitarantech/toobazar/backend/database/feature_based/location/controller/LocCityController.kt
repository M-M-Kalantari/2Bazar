package com.bitarantech.toobazar.backend.database.feature_based.location.controller

import com.bitarantech.toobazar.backend.database.feature_based.location.dto.LocCityResponse
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocCityService
import com.bitarantech.toobazar.backend.database.feature_based.location.dto.toResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LocCityController(
    val service: LocCityService
) {

    @GetMapping("loc_city")
    fun getCities(): List<LocCityResponse> = service.findAll().map { it.toResponse(false) }

}