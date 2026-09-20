package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_response.LocCityResponse
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.services.LocCityService
import com.bitarantech.toobazar.backend.database.services.ParameterService
import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.ApiException
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class ParameterController(
    val service: ParameterService
) {

    @GetMapping("parameter")
    fun getParameters(
        @RequestParam(value = "categoryId") categoryId: Long? = null,
    ): ResponseEntity<*> {
        return categoryId?.let { categoryId ->
            ApiResponse.success(
                Successes.SUC_200_OK.RETRIEVED,
                service.findByCategory(categoryId).map { it.toResponse(includeCategories = false) }
            )
        } ?: ApiResponse.success(
            Successes.SUC_200_OK.RETRIEVED,
            service.findAll().map { it.toResponse() }
        )
    }

}