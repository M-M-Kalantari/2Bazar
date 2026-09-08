package com.bitarantech.toobazar.backend.database.dto_response

import com.bitarantech.toobazar.backend.database.entities.UserEntity
import java.time.Instant

data class UserResponse(
    val name: String,
    val family: String,
    val phone: String,
    val email: String,
    val token: String,
    val created_at: Instant?,
    val updated_at: Instant?,
)

fun UserEntity.toResponse(token: String): UserResponse {
    return UserResponse(
        name = name,
        family = family,
        phone = phone,
        email = email,
        token = token,
        created_at = created_at,
        updated_at = updated_at,
    )
}