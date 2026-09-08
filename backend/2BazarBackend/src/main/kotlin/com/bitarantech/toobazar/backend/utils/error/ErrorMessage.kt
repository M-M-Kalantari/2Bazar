package com.bitarantech.toobazar.backend.utils.error

data class ErrorMessage(
    val fa: String,
    val en: String
) {

    fun get(language: ErrorLanguage): String {
        return when (language) {
            ErrorLanguage.FA -> fa
            ErrorLanguage.EN -> en
            ErrorLanguage.BOTH -> "$fa\n$en"
        }
    }
}