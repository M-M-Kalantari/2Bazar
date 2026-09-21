package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.services.LocProvinceService
import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LocationController(
    val service: LocProvinceService
) {

    @GetMapping("location")
    fun getProvinces(
        @RequestParam("includeCities") includeCities: Boolean? = true,
        @RequestParam("includeNeighborhoods") includeNeighborhoods: Boolean? = true
    ): ResponseEntity<*> {
        return ApiResponse.success(
            Successes.SUC_200_OK.RETRIEVED,
            service.findAll().map {
                it.toResponse(
                    includeCities = includeCities ?: true,
                    includeNeighborhoods = includeNeighborhoods ?: true
                )
            }
        )
    }

}