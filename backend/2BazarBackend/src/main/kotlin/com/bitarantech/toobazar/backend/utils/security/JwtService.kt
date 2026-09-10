package com.bitarantech.toobazar.backend.utils.security

import com.bitarantech.toobazar.backend.database.entities.UserEntity
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {

    @Value("\${jwt.secret}")
    lateinit var key: String

    private fun getSignKey(): SecretKey? {
        val keyBytes = Decoders.BASE64.decode(key)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun generate(
        user: UserEntity,
        expirationDate: Date = Date.from(Instant.now().plusSeconds(60 * 60 * 24 * 30)),
        additionalClaims: Map<String, Any> = emptyMap()
    ): String =
        Jwts.builder()
            .header()
            .add("type", "jwt")
            .and()
            .claims()
            .subject(user.phone)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(expirationDate)
            .add(additionalClaims)
            .and()
            .signWith(getSignKey())
            .compact()

    fun isValid(token: String, user: UserEntity): Boolean {
        val phone = extractPhone(token)
        return user.phone == phone && !isExpired(token)
    }

//    fun extractPhone(token: String?): String? {
//        if (token.isNullOrEmpty()) return null
//        return try {
//            getAllClaims(token.replace("Bearer ", "")).subject
//        } catch (e: Exception) {
//            null
//        }
//    }

    fun extractPhone(token: String?): String? {
        if (token.isNullOrEmpty()) {
            println("TOKEN IS NULL OR EMPTY")
            return null
        }

        return try {
            val cleanToken = token.replace("Bearer ", "")
            println("TOKEN: $cleanToken")

            val claims = getAllClaims(cleanToken)

            println("SUBJECT: ${claims.subject}")
            println("EXPIRATION: ${claims.expiration}")

            claims.subject

        } catch (e: Exception) {
            println("JWT ERROR: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    fun isExpired(token: String): Boolean =
        getAllClaims(token)
            .expiration
            .before(Date(System.currentTimeMillis()))

    private fun getAllClaims(token: String): Claims {
        val parser = Jwts.parser()
            .verifyWith(getSignKey())
            .build()

        return parser
            .parseSignedClaims(token)
            .payload
    }
}

