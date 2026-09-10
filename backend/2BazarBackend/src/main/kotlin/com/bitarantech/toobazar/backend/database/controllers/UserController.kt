package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_request.UserRequest
import com.bitarantech.toobazar.backend.database.dto_request.toEntity
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.services.UserService
import com.bitarantech.toobazar.backend.utils.error.ApiException
import com.bitarantech.toobazar.backend.utils.error.Errors
import com.bitarantech.toobazar.backend.utils.security.JwtService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class UserController(
    val service: UserService,
    val jwtService: JwtService
) {

    @PostMapping("user")
    fun addUser(
        @RequestBody user: UserRequest? = null
    ): Any {
        return if (user == null) {
            throw ApiException(Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY)
        } else {
            val entity = user.toEntity()
            val token = jwtService.generate(entity)
            val savedUser = service.save(entity)
            savedUser.toResponse(token)
        }
    }

    @GetMapping("user")
    fun getUser(
        @RequestHeader("Authorization") token: String?,
    ): Any? {
        if (token.isNullOrEmpty()) {
            throw ApiException(Errors.ERR_401_UNAUTHORIZED.MISSING_TOKEN)
        } else {
            val phone = jwtService.extractPhone(token)
            return if (phone.isNullOrEmpty()) {
                throw ApiException(Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY)
            } else {
                service.findByPhone(phone)?.toResponse("")
            }
        }
    }

}

/***
// 1
{
"name": "آریا",
"family": "نیک‌فر",
"phone": "09121234567",
"email": "arya.nikfar@example.com",
"password": "Arya@123456"
}

// 2
{
"name": "سپیده",
"family": "فرهمند",
"phone": "09129876543",
"email": "sepideh.farahmand@example.com",
"password": "Sepideh@123456"
}

// 3
{
"name": "بردیا",
"family": "دادگر",
"phone": "09351234789",
"email": "bardia.dadgar@example.com",
"password": "Bardia@123456"
}

// 4
{
"name": "بهار",
"family": "نیک‌نام",
"phone": "09367894512",
"email": "bahar.niknam@example.com",
"password": "Bahar@123456"
}
 ***/