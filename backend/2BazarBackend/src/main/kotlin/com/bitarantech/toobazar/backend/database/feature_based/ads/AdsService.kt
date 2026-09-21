package com.bitarantech.toobazar.backend.database.feature_based.ads

import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.AdsRequest
import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.toEntity
import com.bitarantech.toobazar.backend.database.feature_based.ads.dto.toResponse
import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryService
import com.bitarantech.toobazar.backend.database.feature_based.image.ImageService
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocNeighborhoodService
import com.bitarantech.toobazar.backend.database.feature_based.parameter.dto.toEntity
import com.bitarantech.toobazar.backend.database.feature_based.parameter.service.ParameterService
import com.bitarantech.toobazar.backend.database.feature_based.parameter.service.ParameterValueService
import com.bitarantech.toobazar.backend.database.feature_based.user.UserService
import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import com.bitarantech.toobazar.backend.utils.security.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AdsService(
    val repository: AdsRepository,
    val userService: UserService,
    val jwtService: JwtService,
    val neighborhoodService: LocNeighborhoodService,
    val categoryService: CategoryService,
    val parameterValueService: ParameterValueService,
    val parameterService: ParameterService,
    val imageService: ImageService
) {

    fun findAll(): List<AdsEntity> = repository.findAll()

    fun save(adsRequest: AdsRequest, token: String, images: List<MultipartFile>?): ResponseEntity<*> {
        return jwtService.extractPhone(token)?.let { phone ->
            userService.findByPhone(phone)?.let { dbUser ->

                val location = neighborhoodService.getReferenceById(adsRequest.locationId)
                    ?: ApiResponse.error(Errors.ERR_404_NOT_FOUND.LOCATION_NOT_FOUND)

                val category = categoryService.getReferenceById(adsRequest.categoryId)
                    ?: ApiResponse.error(Errors.ERR_404_NOT_FOUND.CATEGORY_NOT_FOUND)

                val ads = repository.save(adsRequest.toEntity(location, category, dbUser))

                parameterValueService.saveAll(adsRequest.parameterValues.map {
                    it.toEntity(
                        ads = ads,
                        parameter = parameterService.getReferenceById(it.parameterId)
                            ?: ApiResponse.error(Errors.ERR_404_NOT_FOUND.CATEGORY_NOT_FOUND)

                    )
                })

                images?.let {
                    imageService.saveAll(files = it, ads = ads)
                }

                return ApiResponse.success(
                    Successes.SUC_201_CREATED.ADS_CREATED,
                    ads.toResponse()
                )

            } ?: ApiResponse.error(Errors.ERR_404_NOT_FOUND.USER_NOT_FOUND)
        } ?: ApiResponse.error(Errors.ERR_401_UNAUTHORIZED.INVALID_TOKEN)
    }

    fun saveAll(entityList: List<AdsEntity>): List<AdsEntity?> = repository.saveAll(entityList)

    fun count(): Long = repository.count()

}