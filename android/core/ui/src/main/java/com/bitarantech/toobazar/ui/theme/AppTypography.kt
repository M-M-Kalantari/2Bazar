package com.bitarantech.toobazar.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import com.bitarantech.toobazar.ui.R


private val vazirmatnThin = FontFamily(Font(R.font.vazirmatn_fd_thin, FontWeight.Thin))

private val vazirmatnExtraLight = FontFamily(Font(R.font.vazirmatn_fd_extra_light, FontWeight.ExtraLight))

private val vazirmatnLight = FontFamily(Font(R.font.vazirmatn_fd_light, FontWeight.Light))

private val vazirmatnRegular = FontFamily(Font(R.font.vazirmatn_fd_regular, FontWeight.Normal))

private val vazirmatnMedium = FontFamily(Font(R.font.vazirmatn_fd_medium, FontWeight.Medium))

private val vazirmatnSemiBold = FontFamily(Font(R.font.vazirmatn_fd_semi_bold, FontWeight.SemiBold))

private val vazirmatnBold = FontFamily(Font(R.font.vazirmatn_fd_bold, FontWeight.Bold))

private val vazirmatnExtraBold = FontFamily(Font(R.font.vazirmatn_fd_extra_bold, FontWeight.ExtraBold))

private val vazirmatnBlack = FontFamily(Font(R.font.vazirmatn_fd_black, FontWeight.Black))


data class AppTypography(

    val titleLarge: TextStyle = TextStyle(
        fontFamily = vazirmatnBlack,
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Rtl,
        fontSize = 24.sp,
    ),

    val title: TextStyle = TextStyle(
        fontFamily = vazirmatnExtraBold,
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Rtl,
        fontSize = 18.sp,
    ),

    val bodyMediumBold: TextStyle = TextStyle(
        fontFamily = vazirmatnBold,
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Rtl,
        fontSize = 16.sp,
    ),

    val bodyLarge: TextStyle = TextStyle(
        fontFamily = vazirmatnSemiBold,
        fontWeight = FontWeight.Normal,
        textDirection = TextDirection.Rtl,
        fontSize = 18.sp,
    ),

    val bodyMedium: TextStyle = TextStyle(
        fontFamily = vazirmatnSemiBold,
        fontWeight = FontWeight.Normal,
        textDirection = TextDirection.Rtl,
        fontSize = 16.sp,
    ),

    val labelMedium: TextStyle = TextStyle(
        fontFamily = vazirmatnMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        textDirection = TextDirection.Rtl,
        lineHeight = 24.sp,
    ),

    val labelSmall: TextStyle = TextStyle(
        fontFamily = vazirmatnRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        textDirection = TextDirection.Rtl,
    ),
)

val LocalTypography = staticCompositionLocalOf { AppTypography() }