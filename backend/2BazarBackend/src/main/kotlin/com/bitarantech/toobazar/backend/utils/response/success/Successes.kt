package com.bitarantech.toobazar.backend.utils.response.success

import com.bitarantech.toobazar.backend.utils.response.ApiResponseMessage
import com.bitarantech.toobazar.backend.utils.response.ApiResponseInfo
import org.springframework.http.HttpStatus

object Successes {

    // =========================================================
    // 200 - OK
    // =========================================================

    object SUC_200_OK {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "SUCCESS",
            message = ApiResponseMessage(
                fa = "عملیات با موفقیت انجام شد.",
                en = "Operation completed successfully."
            )
        )

        val UPDATED = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "UPDATED",
            message = ApiResponseMessage(
                fa = "اطلاعات با موفقیت به‌روزرسانی شد.",
                en = "The data was updated successfully."
            )
        )

        val DELETED = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "DELETED",
            message = ApiResponseMessage(
                fa = "اطلاعات با موفقیت حذف شد.",
                en = "The data was deleted successfully."
            )
        )

        val USER_UPDATED = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "USER_UPDATED",
            message = ApiResponseMessage(
                fa = "اطلاعات کاربر با موفقیت به‌روزرسانی شد.",
                en = "User information was updated successfully."
            )
        )

        val USER_DELETED = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "USER_DELETED",
            message = ApiResponseMessage(
                fa = "کاربر با موفقیت حذف شد.",
                en = "User deleted successfully."
            )
        )

        val USER_RETRIEVED = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "USER_RETRIEVED",
            message = ApiResponseMessage(
                fa = "کاربر با موفقیت دریافت شد.",
                en = "User received successfully."
            )
        )

        val LOGIN_SUCCESS = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "LOGIN_SUCCESS",
            message = ApiResponseMessage(
                fa = "ورود با موفقیت انجام شد.",
                en = "Login successful."
            )
        )

        val LOGOUT_SUCCESS = ApiResponseInfo(
            httpStatus = HttpStatus.OK,
            code = "LOGOUT_SUCCESS",
            message = ApiResponseMessage(
                fa = "با موفقیت خارج شدید.",
                en = "Logout successful."
            )
        )
    }


    // =========================================================
    // 201 - CREATED
    // =========================================================

    object SUC_201_CREATED {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.CREATED,
            code = "CREATED",
            message = ApiResponseMessage(
                fa = "اطلاعات با موفقیت ایجاد شد.",
                en = "The data was created successfully."
            )
        )

        val USER_CREATED = ApiResponseInfo(
            httpStatus = HttpStatus.CREATED,
            code = "USER_CREATED",
            message = ApiResponseMessage(
                fa = "کاربر با موفقیت ایجاد شد.",
                en = "User created successfully."
            )
        )
    }


    // =========================================================
    // 202 - ACCEPTED
    // =========================================================

    object SUC_202_ACCEPTED {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.ACCEPTED,
            code = "ACCEPTED",
            message = ApiResponseMessage(
                fa = "درخواست با موفقیت دریافت شد و در حال پردازش است.",
                en = "The request was accepted and is being processed."
            )
        )
    }


    // =========================================================
    // 204 - NO_CONTENT
    // =========================================================

    object SUC_204_NO_CONTENT {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.NO_CONTENT,
            code = "NO_CONTENT",
            message = ApiResponseMessage(
                fa = "عملیات با موفقیت انجام شد.",
                en = "The operation was completed successfully."
            )
        )
    }
}