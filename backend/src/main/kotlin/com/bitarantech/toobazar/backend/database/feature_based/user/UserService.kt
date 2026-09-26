package com.bitarantech.toobazar.backend.database.feature_based.user

import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository
) {

    fun hashPassword(password: String): String = BCryptPasswordEncoder().encode(password)!!

    fun create(entity: UserEntity): UserEntity {
        return try {
            repository.save(
                entity.copy(
                    password = hashPassword(entity.password)
                )
            )
        } catch (e: DataIntegrityViolationException) {
            ApiResponse.error(Errors.ERR_409_CONFLICT.PHONE_ALREADY_EXISTS)
        }
    }

    fun update(entity: UserEntity): UserEntity {
        return try {
            repository.save(entity)
        } catch (e: DataIntegrityViolationException) {
            ApiResponse.error(Errors.ERR_409_CONFLICT.PHONE_ALREADY_EXISTS)
        }
    }

    fun findByPhone(phone: String?): UserEntity? = repository.findByPhone(phone)

    fun findByEmail(email: String?): UserEntity? = repository.findByEmail(email)

}