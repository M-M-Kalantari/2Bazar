package com.bitarantech.toobazar.backend.database.feature_based.ads

import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.AdsRequest
import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
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
    fun getAds(): ResponseEntity<*> {
        return ApiResponse.success(
            Successes.SUC_200_OK.RETRIEVED,
            TODO()
        )
    }

}

/***
{
"title": "گوشی سامسونگ Galaxy S24",
"description": "گوشی کاملاً سالم با حافظه 256 گیگابایت",
"price": "45000000",
"locationId": 60,
"categoryId": 23,
"parameterValues": [
{
"value": "سبز",
"parameterId": 13
},
{
"value": "256GB",
"parameterId": 14
},
{
"value": "Android",
"parameterId": 26
},
{
"value": "4600",
"parameterId": 27
},
{
"value": "دو سیم‌کارت",
"parameterId": 28
}
]
}

{"title":"گوشی سامسونگ Galaxy S24","description":"گوشی کاملاً سالم با حافظه 256 گیگابایت","price":"45000000","locationId":60,"categoryId":23,"parameterValues":[{"value":"سبز","parameterId":13},{"value":"256GB","parameterId":14},{"value":"Android","parameterId":26},{"value":"4600","parameterId":27},{"value":"دو سیم‌کارت","parameterId":28}]}
***/