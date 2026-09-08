package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_request.UserRequest
import com.bitarantech.toobazar.backend.database.dto_request.toEntity
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.services.UserService
import com.bitarantech.toobazar.backend.utils.error.ApiException
import com.bitarantech.toobazar.backend.utils.error.Errors
import com.bitarantech.toobazar.backend.utils.security.JwtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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
        @RequestParam("Authorization") token: String?,
    ): Any {
        return if (token.isNullOrEmpty()) {
            throw ApiException(Errors.ERR_401_UNAUTHORIZED.MISSING_TOKEN)
        }else{
            ""
        }
    }

}