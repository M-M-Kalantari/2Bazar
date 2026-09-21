package com.bitarantech.toobazar.backend.database.feature_based.category

import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class CategoryController(
    val service: CategoryService
) {

    @GetMapping("category")
    fun getCategories(): ResponseEntity<*> {
        return ApiResponse.success(
            Successes.SUC_200_OK.RETRIEVED,
            service.findAll().map { it.toResponse() }
        )
    }

}