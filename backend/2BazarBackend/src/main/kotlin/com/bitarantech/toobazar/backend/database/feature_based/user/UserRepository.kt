package com.bitarantech.toobazar.backend.database.feature_based.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByPhone(phone: String?): UserEntity?
    fun findByEmail(email: String?): UserEntity?
}