package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_response.LocNeighborhoodResponse
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.services.LocNeighborhoodService
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