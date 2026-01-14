package org.luxtype.inputmethod.engine

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.luxtype.inputmethod.engine.general.JapaneseIMESettings
import org.luxtype.inputmethod.latin.R
import org.luxtype.inputmethod.latin.Subtypes
import org.luxtype.inputmethod.latin.SubtypesSetting
import org.luxtype.inputmethod.latin.uix.settings.NavigationItemStyle
import org.luxtype.inputmethod.latin.uix.settings.UserSettingsMenu
import org.luxtype.inputmethod.latin.uix.settings.useDataStoreValue
import org.luxtype.inputmethod.latin.uix.settings.userSettingNavigationItem

@Composable
private fun isVisible(language: String): Boolean {
    val subtypeSet = useDataStoreValue(SubtypesSetting)
    return remember(subtypeSet) {
        subtypeSet.any {
            Subtypes.getLocale(Subtypes.convertToSubtype(it).locale).language == language
        }
    }
}

val SettingsByLanguage = mapOf(
    "ja" to JapaneseIMESettings.menu.copy(visibilityCheck = { isVisible("ja") })
)

@Composable
private fun anyVisible(): Boolean {
    val subtypeSet = useDataStoreValue(SubtypesSetting)
    return remember(subtypeSet) {
        subtypeSet.any {
            SettingsByLanguage.containsKey(Subtypes.getLocale(Subtypes.convertToSubtype(it).locale).language)
        }
    }
}

private val IMESettings = buildList {
    SettingsByLanguage.forEach {
        add(
            userSettingNavigationItem(
                title = it.value.title,
                style = NavigationItemStyle.HomePrimary,
                icon = R.drawable.globe,
                navigateTo = it.value.navPath,
            ).copy(
                visibilityCheck = it.value.visibilityCheck,
                appearInSearchIfVisibilityCheckFailed = false
            )
        )
    }
}

val IMESettingsMenu = UserSettingsMenu(
    title = R.string.language_specific_settings_title,
    navPath = "ime", registerNavPath = true,
    settings = IMESettings, visibilityCheck = { anyVisible() }
)
