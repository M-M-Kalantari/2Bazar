package com.bitarantech.toobazar.backend.database.controllers

import com.bitarantech.toobazar.backend.database.dto_request.UserRequest
import com.bitarantech.toobazar.backend.database.dto_request.toEntity
import com.bitarantech.toobazar.backend.database.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class UserController(
    val service: UserService
) {

    @PostMapping("user")
    fun addUser(
        @RequestBody user: UserRequest? = null
    ): Any {
        return if (user == null) {
            "fill this request"
        } else {
            service.save(user.toEntity())
        }
    }

}