package com.bitarantech.toobazar.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)

//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)


object AppTheme {
    val colors: AppColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

    val dimensions: AppDimension
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val shapes: AppShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

private val DarkColorScheme = AppColor(
    primaryColor = PrimaryColorDark,
    itemColor = ItemColorDark,
    iconColor = IconColorDark,
    textColor = TextColorDark,
    hintColor = HintColorDark,
    titleColor = TitleColorDark,
    backgroundColor = BackgroundColorDark,
    errorColor = ErrorColorDark,
    disableColor = DisableColorDark,
    successColor = SuccessColorDark
)

private val LightColorScheme = AppColor(
    primaryColor = PrimaryColorLight,
    itemColor = ItemColorLight,
    iconColor = IconColorLight,
    textColor = TextColorLight,
    hintColor = HintColorLight,
    titleColor = TitleColorLight,
    backgroundColor = BackgroundColorLight,
    errorColor = ErrorColorLight,
    disableColor = DisableColorLight,
    successColor = SuccessColorLight
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalColor provides colorScheme,
        LocalDimensions provides AppTheme.dimensions,
        LocalShapes provides AppTheme.shapes,
        LocalTypography provides AppTheme.typography
    ) {
        content()
    }

//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
}