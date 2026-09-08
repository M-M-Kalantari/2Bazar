package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_request.UserRequest
import com.bitarantech.toobazar.backend.database.dto_request.toEntity
import com.bitarantech.toobazar.backend.database.dto_response.toResponse
import com.bitarantech.toobazar.backend.database.services.UserService
import com.bitarantech.toobazar.backend.utils.security.JwtService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
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
            "fill this request"
        } else {
            val entity = user.toEntity()
            val token = jwtService.generate(entity)
            val savedUser = service.save(entity)
            return savedUser.toResponse(token)
        }
    }

}