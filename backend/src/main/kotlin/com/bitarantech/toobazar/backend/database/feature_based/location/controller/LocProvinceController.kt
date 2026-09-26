package com.bitarantech.toobazar.backend.database.feature_based.location.controller

import com.bitarantech.toobazar.backend.database.feature_based.location.entity.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.feature_based.location.dto.LocProvinceResponse
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocProvinceService
import com.bitarantech.toobazar.backend.database.feature_based.location.dto.toResponse
import com.bitarantech.toobazar.backend.utils.response.error.ApiException
import com.bitarantech.toobazar.backend.utils.response.error.Errors
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