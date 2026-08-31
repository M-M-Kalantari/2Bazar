package com.bitarantech.toobazar.backend.database.services

import com.bitarantech.toobazar.backend.database.entities.CategoryEntity
import com.bitarantech.toobazar.backend.database.entities.UserEntity
import com.bitarantech.toobazar.backend.database.repositories.CategoryRepository
import com.bitarantech.toobazar.backend.database.repositories.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository
) {

    fun findAll(): List<UserEntity> = repository.findAll()

    fun save(entity: UserEntity): UserEntity {
        return repository.save(entity.copy(password = hashPassword(entity.password)))
    }

    fun count(): Long = repository.count()

    fun hashPassword(password: String): String = BCryptPasswordEncoder().encode(password)!!
}