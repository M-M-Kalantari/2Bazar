package com.bitarantech.toobazar.backend.utils.response.error

import com.bitarantech.toobazar.backend.utils.response.ApiResponseMessage
import com.bitarantech.toobazar.backend.utils.response.ApiResponseInfo
import org.springframework.http.HttpStatus

object Errors {

    // =========================================================
    // 400 - BAD REQUEST
    // =========================================================

    object ERR_400_BAD_REQUEST {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "BAD_REQUEST",
            message = ApiResponseMessage(
                fa = "درخواست نامعتبر است.",
                en = "Bad request."
            )
        )

        val INVALID_DATA = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "INVALID_DATA",
            message = ApiResponseMessage(
                fa = "اطلاعات ارسال شده نامعتبر است.",
                en = "The provided data is invalid."
            )
        )

        val INVALID_REQUEST_BODY = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "INVALID_REQUEST_BODY",
            message = ApiResponseMessage(
                fa = "اطلاعات درخواست نامعتبر است.",
                en = "The request body is invalid."
            )
        )

        val MISSING_REQUIRED_PARAMETER = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "MISSING_REQUIRED_PARAMETER",
            message = ApiResponseMessage(
                fa = "یکی از پارامترهای الزامی ارسال نشده است.",
                en = "A required parameter is missing."
            )
        )

        val MISSING_REQUIRED_PARAMETERS = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "MISSING_REQUIRED_PARAMETERS",
            message = ApiResponseMessage(
                fa = "یک یا چند پارامتر الزامی ارسال نشده است.",
                en = "One or more required parameters are missing."
            )
        )

        val INVALID_PARAMETER = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "INVALID_PARAMETER",
            message = ApiResponseMessage(
                fa = "پارامتر ارسال شده نامعتبر است.",
                en = "The provided parameter is invalid."
            )
        )

        val INVALID_PARAMETERS = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "INVALID_PARAMETERS",
            message = ApiResponseMessage(
                fa = "یک یا چند پارامتر نامعتبر است.",
                en = "One or more parameters are invalid."
            )
        )

        val INVALID_PARAMETER_VALUE = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "INVALID_PARAMETER_VALUE",
            message = ApiResponseMessage(
                fa = "مقدار پارامتر نامعتبر است.",
                en = "The parameter value is invalid."
            )
        )

        val INVALID_REQUEST = ApiResponseInfo(
            httpStatus = HttpStatus.BAD_REQUEST,
            code = "INVALID_REQUEST",
            message = ApiResponseMessage(
                fa = "درخواست ارسال شده قابل پردازش نیست.",
                en = "The request cannot be processed."
            )
        )
    }


    // =========================================================
    // 401 - UNAUTHORIZED
    // =========================================================

    object ERR_401_UNAUTHORIZED {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.UNAUTHORIZED,
            code = "UNAUTHORIZED",
            message = ApiResponseMessage(
                fa = "احراز هویت انجام نشده است.",
                en = "Authentication is required."
            )
        )

        val INVALID_CREDENTIALS = ApiResponseInfo(
            httpStatus = HttpStatus.UNAUTHORIZED,
            code = "INVALID_CREDENTIALS",
            message = ApiResponseMessage(
                fa = "نام کاربری یا رمز عبور اشتباه است.",
                en = "Invalid username or password."
            )
        )

        val INVALID_TOKEN = ApiResponseInfo(
            httpStatus = HttpStatus.UNAUTHORIZED,
            code = "INVALID_TOKEN",
            message = ApiResponseMessage(
                fa = "توکن نامعتبر است.",
                en = "Invalid token."
            )
        )

        val EXPIRED_TOKEN = ApiResponseInfo(
            httpStatus = HttpStatus.UNAUTHORIZED,
            code = "EXPIRED_TOKEN",
            message = ApiResponseMessage(
                fa = "توکن منقضی شده است.",
                en = "Token has expired."
            )
        )

        val MISSING_TOKEN = ApiResponseInfo(
            httpStatus = HttpStatus.UNAUTHORIZED,
            code = "MISSING_TOKEN",
            message = ApiResponseMessage(
                fa = "توکن احراز هویت ارسال نشده است.",
                en = "Authentication token is missing."
            )
        )
    }


    // =========================================================
    // 403 - FORBIDDEN
    // =========================================================

    object ERR_403_FORBIDDEN {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.FORBIDDEN,
            code = "FORBIDDEN",
            message = ApiResponseMessage(
                fa = "شما اجازه دسترسی به این بخش را ندارید.",
                en = "You do not have permission to access this resource."
            )
        )

        val ACCESS_DENIED = ApiResponseInfo(
            httpStatus = HttpStatus.FORBIDDEN,
            code = "ACCESS_DENIED",
            message = ApiResponseMessage(
                fa = "دسترسی به این بخش امکان‌پذیر نیست.",
                en = "Access to this resource is denied."
            )
        )

        val INSUFFICIENT_PERMISSION = ApiResponseInfo(
            httpStatus = HttpStatus.FORBIDDEN,
            code = "INSUFFICIENT_PERMISSION",
            message = ApiResponseMessage(
                fa = "شما مجوز انجام این عملیات را ندارید.",
                en = "You do not have permission to perform this operation."
            )
        )
    }


    // =========================================================
    // 404 - NOT FOUND
    // =========================================================

    object ERR_404_NOT_FOUND {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "NOT_FOUND",
            message = ApiResponseMessage(
                fa = "اطلاعات مورد نظر پیدا نشد.",
                en = "The requested resource was not found."
            )
        )

        val USER_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "USER_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "کاربر پیدا نشد.",
                en = "User not found."
            )
        )

        val PRODUCT_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "PRODUCT_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "آگهی مورد نظر پیدا نشد.",
                en = "Product not found."
            )
        )

        val IMAGE_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "IMAGE_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "تصویر مورد نظر پیدا نشد.",
                en = "Image not found."
            )
        )

        val LOCATION_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "LOCATION_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "موقعیت مورد نظر پیدا نشد.",
                en = "Location not found."
            )
        )

        val PROVINCE_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "PROVINCE_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "استان مورد نظر پیدا نشد.",
                en = "Province not found."
            )
        )

        val CITY_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "CITY_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "شهر مورد نظر پیدا نشد.",
                en = "City not found."
            )
        )

        val NEIGHBORHOOD_NOT_FOUND = ApiResponseInfo(
            httpStatus = HttpStatus.NOT_FOUND,
            code = "NEIGHBORHOOD_NOT_FOUND",
            message = ApiResponseMessage(
                fa = "محله مورد نظر پیدا نشد.",
                en = "Neighborhood not found."
            )
        )
    }


    // =========================================================
    // 409 - CONFLICT
    // =========================================================

    object ERR_409_CONFLICT {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.CONFLICT,
            code = "CONFLICT",
            message = ApiResponseMessage(
                fa = "این درخواست با وضعیت فعلی اطلاعات سازگار نیست.",
                en = "The request conflicts with the current state of the resource."
            )
        )

        val EMAIL_ALREADY_EXISTS = ApiResponseInfo(
            httpStatus = HttpStatus.CONFLICT,
            code = "EMAIL_ALREADY_EXISTS",
            message = ApiResponseMessage(
                fa = "این ایمیل قبلاً ثبت شده است.",
                en = "This email is already registered."
            )
        )

        val PHONE_ALREADY_EXISTS = ApiResponseInfo(
            httpStatus = HttpStatus.CONFLICT,
            code = "PHONE_ALREADY_EXISTS",
            message = ApiResponseMessage(
                fa = "این شماره تلفن قبلاً ثبت شده است.",
                en = "This phone number is already registered."
            )
        )

        val USER_ALREADY_EXISTS = ApiResponseInfo(
            httpStatus = HttpStatus.CONFLICT,
            code = "USER_ALREADY_EXISTS",
            message = ApiResponseMessage(
                fa = "این کاربر قبلاً ثبت شده است.",
                en = "This user already exists."
            )
        )

        val DATA_ALREADY_EXISTS = ApiResponseInfo(
            httpStatus = HttpStatus.CONFLICT,
            code = "DATA_ALREADY_EXISTS",
            message = ApiResponseMessage(
                fa = "این اطلاعات قبلاً ثبت شده است.",
                en = "This data already exists."
            )
        )
    }


    // =========================================================
    // 422 - UNPROCESSABLE ENTITY
    // =========================================================

    object ERR_422_UNPROCESSABLE_ENTITY {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "VALIDATION_ERROR",
            message = ApiResponseMessage(
                fa = "اطلاعات وارد شده دارای خطا است.",
                en = "The provided data contains validation errors."
            )
        )

        val INVALID_EMAIL = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "INVALID_EMAIL",
            message = ApiResponseMessage(
                fa = "فرمت ایمیل نامعتبر است.",
                en = "The email format is invalid."
            )
        )

        val INVALID_PHONE = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "INVALID_PHONE",
            message = ApiResponseMessage(
                fa = "فرمت شماره تلفن نامعتبر است.",
                en = "The phone number format is invalid."
            )
        )

        val INVALID_PASSWORD = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "INVALID_PASSWORD",
            message = ApiResponseMessage(
                fa = "رمز عبور شرایط لازم را ندارد.",
                en = "The password does not meet the required conditions."
            )
        )

        val PASSWORD_TOO_SHORT = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "PASSWORD_TOO_SHORT",
            message = ApiResponseMessage(
                fa = "رمز عبور بیش از حد کوتاه است.",
                en = "The password is too short."
            )
        )

        val INVALID_ID = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "INVALID_ID",
            message = ApiResponseMessage(
                fa = "شناسه ارسال شده نامعتبر است.",
                en = "The provided ID is invalid."
            )
        )

        val INVALID_DATE = ApiResponseInfo(
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
            code = "INVALID_DATE",
            message = ApiResponseMessage(
                fa = "تاریخ وارد شده نامعتبر است.",
                en = "The provided date is invalid."
            )
        )
    }


    // =========================================================
    // 429 - TOO MANY REQUESTS
    // =========================================================

    object ERR_429_TOO_MANY_REQUESTS {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.TOO_MANY_REQUESTS,
            code = "TOO_MANY_REQUESTS",
            message = ApiResponseMessage(
                fa = "تعداد درخواست‌ها بیش از حد مجاز است.",
                en = "Too many requests."
            )
        )

        val TOO_MANY_LOGIN_ATTEMPTS = ApiResponseInfo(
            httpStatus = HttpStatus.TOO_MANY_REQUESTS,
            code = "TOO_MANY_LOGIN_ATTEMPTS",
            message = ApiResponseMessage(
                fa = "تعداد تلاش‌های ورود بیش از حد مجاز است.",
                en = "Too many login attempts."
            )
        )
    }


    // =========================================================
    // 500 - INTERNAL SERVER ERROR
    // =========================================================

    object ERR_500_INTERNAL_SERVER_ERROR {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            code = "INTERNAL_SERVER_ERROR",
            message = ApiResponseMessage(
                fa = "خطایی در سرور رخ داده است.",
                en = "An internal server error occurred."
            )
        )

        val DATABASE_ERROR = ApiResponseInfo(
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            code = "DATABASE_ERROR",
            message = ApiResponseMessage(
                fa = "خطایی هنگام دسترسی به پایگاه داده رخ داده است.",
                en = "An error occurred while accessing the database."
            )
        )

        val FILE_UPLOAD_ERROR = ApiResponseInfo(
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            code = "FILE_UPLOAD_ERROR",
            message = ApiResponseMessage(
                fa = "خطایی هنگام آپلود فایل رخ داده است.",
                en = "An error occurred while uploading the file."
            )
        )

        val FILE_DELETE_ERROR = ApiResponseInfo(
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            code = "FILE_DELETE_ERROR",
            message = ApiResponseMessage(
                fa = "خطایی هنگام حذف فایل رخ داده است.",
                en = "An error occurred while deleting the file."
            )
        )

        val UNEXPECTED_ERROR = ApiResponseInfo(
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            code = "UNEXPECTED_ERROR",
            message = ApiResponseMessage(
                fa = "خطای غیرمنتظره‌ای در سرور رخ داده است.",
                en = "An unexpected server error occurred."
            )
        )
    }


    // =========================================================
    // 503 - SERVICE UNAVAILABLE
    // =========================================================

    object ERR_503_SERVICE_UNAVAILABLE {

        val GENERAL = ApiResponseInfo(
            httpStatus = HttpStatus.SERVICE_UNAVAILABLE,
            code = "SERVICE_UNAVAILABLE",
            message = ApiResponseMessage(
                fa = "سرویس موقتاً در دسترس نیست.",
                en = "The service is temporarily unavailable."
            )
        )
    }
}