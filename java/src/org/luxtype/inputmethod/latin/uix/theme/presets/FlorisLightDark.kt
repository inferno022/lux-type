package org.luxtype.inputmethod.latin.uix.theme.presets

import androidx.compose.ui.graphics.Color
import org.luxtype.inputmethod.latin.R
import org.luxtype.inputmethod.latin.uix.extendedDarkColorScheme
import org.luxtype.inputmethod.latin.uix.extendedLightColorScheme
import org.luxtype.inputmethod.latin.uix.theme.ThemeOption

private const val FLORIS_KEY_ROUNDNESS = 0.9f

private val florisDayScheme = extendedLightColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color(0xFFF0F0F0),
    primaryContainer = Color(0xFF388E3C),
    onPrimaryContainer = Color(0xFFF0F0F0),
    secondary = Color(0xFFFF9800),
    onSecondary = Color(0xFF121212),
    secondaryContainer = Color(0xFFFFE0B2),
    onSecondaryContainer = Color(0xFF121212),
    tertiary = Color(0xFF4CAF50),
    onTertiary = Color(0xFFF0F0F0),
    tertiaryContainer = Color(0xFF388E3C),
    onTertiaryContainer = Color(0xFFF0F0F0),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    outline = Color(0xFFB0B0B0),
    outlineVariant = Color(0xFFD0D0D0),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),
    onSurfaceVariant = Color(0xFF5F5F5F),
    surfaceContainerHighest = Color(0xFFF5F5F5),
    shadow = Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface = Color(0xFFE0E0E0),
    keyboardSurfaceDim = Color(0xFFD0D0D0),
    keyboardContainer = Color(0xFFFFFFFF),
    keyboardContainerVariant = Color(0xFFF5F5F5),
    onKeyboardContainer = Color(0xFF000000),
    keyboardPress = Color(0xFFBDBDBD),
    keyboardContainerPressed = Color(0xFFBDBDBD),
    onKeyboardContainerPressed = Color(0xFF000000),
    keyboardFade0 = Color(0xFFE0E0E0),
    keyboardFade1 = Color(0xFFE0E0E0),
    primaryTransparent = Color(0xFF4CAF50).copy(alpha = 0.3f),
    onSurfaceTransparent = Color(0xFF000000).copy(alpha = 0.1f),
).let { scheme ->
    scheme.copy(
        extended = scheme.extended.copy(
            advancedThemeOptions = scheme.extended.advancedThemeOptions.copy(
                keyRoundness = FLORIS_KEY_ROUNDNESS,
                keyBorders = true,
            )
        )
    )
}

private val florisDayBorderlessScheme = florisDayScheme.copy(
    extended = florisDayScheme.extended.copy(
        advancedThemeOptions = florisDayScheme.extended.advancedThemeOptions.copy(
            keyBorders = false,
        )
    )
)

private val florisNightScheme = extendedDarkColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color(0xFFF0F0F0),
    primaryContainer = Color(0xFF388E3C),
    onPrimaryContainer = Color(0xFFF0F0F0),
    secondary = Color(0xFFF57C00),
    onSecondary = Color(0xFF121212),
    secondaryContainer = Color(0xFF5A3A00),
    onSecondaryContainer = Color(0xFFF0F0F0),
    tertiary = Color(0xFF4CAF50),
    onTertiary = Color(0xFFF0F0F0),
    tertiaryContainer = Color(0xFF388E3C),
    onTertiaryContainer = Color(0xFFF0F0F0),
    error = Color(0xFFFF8678),
    onError = Color(0xFF631E21),
    errorContainer = Color(0xFF7A252B),
    onErrorContainer = Color(0xFFFFD6D6),
    outline = Color(0xFF616161),
    outlineVariant = Color(0xFF313131),
    surface = Color(0xFF424242),
    onSurface = Color(0xFFFFFFFF),
    onSurfaceVariant = Color(0xFFA0A0A0),
    surfaceContainerHighest = Color(0xFF616161),
    shadow = Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface = Color(0xFF212121),
    keyboardSurfaceDim = Color(0xFF313131),
    keyboardContainer = Color(0xFF424242),
    keyboardContainerVariant = Color(0xFF616161),
    onKeyboardContainer = Color(0xFFFFFFFF),
    keyboardPress = Color(0xFF757575),
    keyboardContainerPressed = Color(0xFF757575),
    onKeyboardContainerPressed = Color(0xFFFFFFFF),
    keyboardFade0 = Color(0xFF212121),
    keyboardFade1 = Color(0xFF212121),
    primaryTransparent = Color(0xFF4CAF50).copy(alpha = 0.3f),
    onSurfaceTransparent = Color(0xFFFFFFFF).copy(alpha = 0.1f),
).let { scheme ->
    scheme.copy(
        extended = scheme.extended.copy(
            advancedThemeOptions = scheme.extended.advancedThemeOptions.copy(
                keyRoundness = FLORIS_KEY_ROUNDNESS,
                keyBorders = true,
            )
        )
    )
}

private val florisNightBorderlessScheme = florisNightScheme.copy(
    extended = florisNightScheme.extended.copy(
        advancedThemeOptions = florisNightScheme.extended.advancedThemeOptions.copy(
            keyBorders = false,
        )
    )
)

val FlorisDay = ThemeOption(
    dynamic = false,
    key = "FlorisDay",
    name = R.string.theme_floris_day,
    available = { true }
) {
    florisDayScheme
}

val FlorisNight = ThemeOption(
    dynamic = false,
    key = "FlorisNight",
    name = R.string.theme_floris_night,
    available = { true }
) {
    florisNightScheme
}

val FlorisDayBorderless = ThemeOption(
    dynamic = false,
    key = "FlorisDayBorderless",
    name = R.string.theme_floris_day_borderless,
    available = { true }
) {
    florisDayBorderlessScheme
}

val FlorisNightBorderless = ThemeOption(
    dynamic = false,
    key = "FlorisNightBorderless",
    name = R.string.theme_floris_night_borderless,
    available = { true }
) {
    florisNightBorderlessScheme
}
