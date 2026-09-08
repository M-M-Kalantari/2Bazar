package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_response.LocProvinceResponse
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.services.LocProvinceService
import com.bitarantech.toobazar.backend.utils.error.ApiException
import com.bitarantech.toobazar.backend.utils.error.Errors
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class LocProvinceController(
    val service: LocProvinceService
) {

    @GetMapping("loc_province")
    fun getProvinces(): List<LocProvinceResponse> = service.findAll().map { it.toResponse(false) }

    @PostMapping("loc_province")
    fun addProvince(
        @RequestParam name: String?
    ): String {
        return if (name.isNullOrEmpty()) {
            throw ApiException(Errors.ERR_400_BAD_REQUEST.MISSING_REQUIRED_PARAMETER)
        } else {
            service.save(LocProvinceEntity(name = name))
            "Saved Successfully"
        }
    }

}