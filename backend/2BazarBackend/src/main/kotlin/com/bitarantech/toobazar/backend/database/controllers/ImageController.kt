package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.services.ImageService
import com.bitarantech.toobazar.backend.utils.response.error.ApiException
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/image")
class ImageController(
    val service: ImageService
) {

    @PostMapping("upload")
    fun uploadImage(
        @RequestParam("file")
        file: MultipartFile? = null
    ): String {
        return if (file == null) {
            throw ApiException(Errors.ERR_400_BAD_REQUEST.MISSING_REQUIRED_PARAMETER)
        } else {
            val image = service.save(file)
            image.path
        }
    }

}