package com.bitarantech.toobazar.backend.database.dto_request

import com.bitarantech.toobazar.backend.database.entities.UserEntity

data class UserRequest(
    val name: String,
    val family: String,
    val phone: String,
    val email: String,
    val password: String,
)

fun UserRequest.toEntity(): UserEntity {
    return UserEntity(
        name = name,
        family = family,
        phone = phone,
        email = email,
        password = password,
    )
}