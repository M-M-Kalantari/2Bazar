package com.bitarantech.toobazar.backend.database.repositories

import com.bitarantech.toobazar.backend.database.entities.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {}