package com.rendonsoft.beerappdemotest.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val primary = Color(0xFF030303)
val on_Primary = Color(0xFFFFFFFF)

val secondary = Color(0xFF198AFF)
val on_Secondary = Color(0xFF37C2EA)

val background = Color(0xFFFFFFFF)
val on_Background = Color(0xFF3B4559)

val surface = Color(0xFF000000)
val on_Surface = Color(0xFF000000)

val tertiary = Color(0xFF37C2EA)
val on_Tertiary = Color(0xFF37C2EA)

val error = Color(0xFFBA1A1A)
val on_Error = Color(0xFFFFFFFF)

val inverse_Surface = Color.Gray

val colorsApp = lightColorScheme(
        primary = primary,
        onPrimary = on_Primary,
        secondary = secondary,
        onSecondary = on_Secondary,
        tertiary = tertiary,
        onTertiary = on_Tertiary,
        error = error,
        onError = on_Error,
        background = background,
        onBackground = on_Background,
        surface = surface,
        onSurface = on_Surface,
        inverseOnSurface = inverse_Surface
)