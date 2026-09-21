package com.bitarantech.toobazar.backend.database.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity(name = "user")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val family: String,

    @Column(nullable = false, unique = true)
    val phone: String,

    val email: String,

    val password: String,

    @CreationTimestamp
    val created_at: Instant? = null,

    @UpdateTimestamp
    val updated_at: Instant? = null,
)