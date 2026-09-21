package com.bitarantech.toobazar.backend.database.feature_based.parameter

import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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
        return categoryId?.let {
            service.findByCategoryIdWithParents(it)?.let { parameters ->
                ApiResponse.success(
                    Successes.SUC_200_OK.RETRIEVED,
                    parameters.map { it.toResponse(includeCategories = false) }
                )
            } ?: ApiResponse.error(
                Errors.ERR_404_NOT_FOUND.CATEGORY_NOT_FOUND
            )
        } ?: run {
            ApiResponse.success(
                Successes.SUC_200_OK.RETRIEVED,
                service.findAll().map { it.toResponse() }
            )
        }
    }

}