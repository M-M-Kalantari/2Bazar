package com.bitarantech.toobazar.backend.database.feature_based.user

import com.bitarantech.toobazar.backend.database.feature_based.user.dto.UserRequest
import com.bitarantech.toobazar.backend.database.feature_based.user.dto.toEntity
import com.bitarantech.toobazar.backend.database.feature_based.user.dto.toResponse
import com.bitarantech.toobazar.backend.utils.response.ApiResponse
import com.bitarantech.toobazar.backend.utils.response.error.Errors
import com.bitarantech.toobazar.backend.utils.response.success.Successes
import com.bitarantech.toobazar.backend.utils.security.JwtService
import org.springframework.web.bind.annotation.*

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
        return user?.let {
            service.findByPhone(it.phone)?.let {
                ApiResponse.error(
                    Errors.ERR_409_CONFLICT.USER_ALREADY_EXISTS
                )
            } ?: run {
                val entity = it.toEntity()
                val token = jwtService.generate(entity)
                val savedUser = service.create(entity)

                ApiResponse.success(
                    Successes.SUC_201_CREATED.USER_CREATED,
                    savedUser.toResponse(token)
                )
            }
        } ?: ApiResponse.error(
            Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY
        )
    }


    @GetMapping("user")
    fun getUser(
        @RequestHeader("Authorization") token: String?
    ): Any {
        return if (token.isNullOrEmpty()) {
            ApiResponse.error(
                Errors.ERR_401_UNAUTHORIZED.MISSING_TOKEN
            )
        } else {
            jwtService.extractPhone(token)?.let { phone ->
                service.findByPhone(phone)?.let { dbUser ->
                    ApiResponse.success(
                        Successes.SUC_200_OK.USER_RETRIEVED,
                        dbUser.toResponse("")
                    )
                } ?: ApiResponse.error(
                    Errors.ERR_404_NOT_FOUND.USER_NOT_FOUND
                )
            } ?: ApiResponse.error(
                Errors.ERR_401_UNAUTHORIZED.INVALID_TOKEN
            )
        }
    }


//    @PutMapping("user")
//    fun updateUser(
//        @RequestBody user: UserRequest? = null
//    ): Any {
//        return user?.let { request ->
//            service.findByPhone(request.phone)?.let { dbUser ->
//
//                val entity = request.toEntity()
//                val savedUser = service.update(entity.copy(id = dbUser.id))
//
//                ApiResponse.success(
//                    Successes.SUC_200_OK.USER_UPDATED,
//                    savedUser.toResponse("")
//                )
//
//            } ?: ApiResponse.error(
//                Errors.ERR_404_NOT_FOUND.USER_NOT_FOUND
//            )
//
//        } ?: ApiResponse.error(
//            Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY
//        )
//    }


    @PutMapping("user")
    fun updateUser(
        @RequestHeader("Authorization") token: String?,
        @RequestBody user: UserRequest? = null
    ): Any {
        return if (token.isNullOrEmpty()) {
            ApiResponse.error(
                Errors.ERR_401_UNAUTHORIZED.MISSING_TOKEN
            )
        } else {
            jwtService.extractPhone(token)?.let { phone ->
                service.findByPhone(phone)?.let { dbUser ->
                    user?.let { request ->
                        val entity = request.toEntity()

                        val savedUser = service.update(
                            entity.copy(id = dbUser.id)
                        )

                        ApiResponse.success(
                            Successes.SUC_200_OK.USER_UPDATED,
                            savedUser.toResponse("")
                        )

                    } ?: ApiResponse.error(
                        Errors.ERR_400_BAD_REQUEST.INVALID_REQUEST_BODY
                    )
                } ?: ApiResponse.error(
                    Errors.ERR_404_NOT_FOUND.USER_NOT_FOUND
                )
            } ?: ApiResponse.error(
                Errors.ERR_401_UNAUTHORIZED.INVALID_TOKEN
            )
        }
    }
}

/***
// 1
{
"name": "آریا",
"family": "نیک‌فر",
"phone": "09121234567",
"email": "arya.nikfar@example.com",
"password": "Arya@123456"
}

// 2
{
"name": "سپیده",
"family": "فرهمند",
"phone": "09129876543",
"email": "sepideh.farahmand@example.com",
"password": "Sepideh@123456"
}

// 3
{
"name": "بردیا",
"family": "دادگر",
"phone": "09351234789",
"email": "bardia.dadgar@example.com",
"password": "Bardia@123456"
}

// 4
{
"name": "بهار",
"family": "نیک‌نام",
"phone": "09367894512",
"email": "bahar.niknam@example.com",
"password": "Bahar@123456"
}

// 4 - updated
{
"name": "بهار",
"family": "نیک‌نام",
"phone": "09367894521",
"email": "bahar21.niknam@example.com",
"password": "Bahar@123456"
}
 ***/