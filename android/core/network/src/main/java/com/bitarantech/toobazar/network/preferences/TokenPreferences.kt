package com.bitarantech.toobazar.network.preferences

import android.content.SharedPreferences
import com.bitarantech.toobazar.secure_shared_pref.SharedPrefConstant
import javax.inject.Inject

class TokenPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun readToken(): String {
        return sharedPreferences.getString(SharedPrefConstant.TOKEN, "") ?: ""
    }
}