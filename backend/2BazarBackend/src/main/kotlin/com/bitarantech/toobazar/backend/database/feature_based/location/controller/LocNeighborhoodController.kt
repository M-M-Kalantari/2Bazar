package com.bitarantech.toobazar.backend.database.feature_based.location.controller

import com.bitarantech.toobazar.backend.database.feature_based.location.dto.LocNeighborhoodResponse
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocNeighborhoodService
import com.bitarantech.toobazar.backend.database.feature_based.location.dto.toResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LocNeighborhoodController(
    val service: LocNeighborhoodService
) {

    @GetMapping("loc_neighborhood")
    fun getCities(): List<LocNeighborhoodResponse> = service.findAll().map { it.toResponse() }

}