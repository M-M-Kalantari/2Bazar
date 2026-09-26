package com.bitarantech.toobazar.backend.database.feature_based.ads

import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.AdsRequest
import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.toSummeryResponse
import com.bitarantech.toobazar.backend.utils.pageable.toPageResponse
import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import tools.jackson.module.kotlin.jacksonObjectMapper

@RestController
@RequestMapping("/api/v1/")
class AdsController(
    val service: AdsService
) {

    @PostMapping("ads")
    fun addAds(
        @RequestPart("images") images: List<MultipartFile>? = null,
        @RequestPart("ads") adsRequestString: String? = null,
        @RequestHeader("Authorization") token: String?
    ): ResponseEntity<*> {
        return if (token.isNullOrEmpty()) {
            ApiResponse.error(
                Errors.ERR_401_UNAUTHORIZED.MISSING_TOKEN
            )
        } else {
            adsRequestString?.let {
                jacksonObjectMapper().readValue(adsRequestString, AdsRequest::class.java)?.let {
                    service.save(it, token, images)
                } ?: ApiResponse.error(
                    Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY
                )
            } ?: ApiResponse.error(
                Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY
            )
        }
    }


    @GetMapping("ads")
    fun getAds(
        @RequestParam("page", required = false) page: Int? = 0,
        @RequestParam("pageSize", required = false) pageSize: Int? = 20,
        @RequestParam("categoryId", required = false) categoryId: Long? = null,
    ): ResponseEntity<*> {
        val adsPage = if (categoryId == null) {
            service.findAll(page ?: 0, pageSize ?: 20)
        } else {
            service.findAll(categoryId, page ?: 0, pageSize ?: 20)
        }

        return ApiResponse.success(
            Successes.SUC_200_OK.RETRIEVED,
            adsPage.toPageResponse { it.toSummeryResponse() }
        )
    }

    @GetMapping("ads/detail")
    fun getAdsDetail(
        @RequestParam("id") adsId: Long?
    ): ResponseEntity<*> {

        return adsId?.let { id ->
            service.findById(id)?.let { ad ->
                ApiResponse.success(
                    Successes.SUC_200_OK.RETRIEVED,
                    ad.toResponse()
                )
            } ?: ApiResponse.error(
                Errors.ERR_404_NOT_FOUND.PRODUCT_NOT_FOUND
            )
        } ?: ApiResponse.error(
            Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY
        )
    }
}
