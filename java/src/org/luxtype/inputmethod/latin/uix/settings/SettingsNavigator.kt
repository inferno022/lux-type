package org.luxtype.inputmethod.latin.uix.settings

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import org.luxtype.inputmethod.engine.IMESettingsMenu
import org.luxtype.inputmethod.engine.SettingsByLanguage
import org.luxtype.inputmethod.latin.R
import org.luxtype.inputmethod.latin.uix.ErrorDialog
import org.luxtype.inputmethod.latin.uix.InfoDialog
import org.luxtype.inputmethod.latin.uix.LocalNavController
import org.luxtype.inputmethod.latin.uix.SettingsExporter.ExportingMenu
import org.luxtype.inputmethod.latin.uix.actions.AllActions
import org.luxtype.inputmethod.latin.uix.settings.pages.ActionEditorScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.ActionsScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.AdvancedParametersScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.BlacklistScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.BlacklistScreenLite
import org.luxtype.inputmethod.latin.uix.settings.pages.CreditsScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.CreditsScreenLite
import org.luxtype.inputmethod.latin.uix.settings.pages.themes.CustomThemeScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.DevEditTextVariationsScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.DevKeyboardScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.DevLayoutEdit
import org.luxtype.inputmethod.latin.uix.settings.pages.DevLayoutEditor
import org.luxtype.inputmethod.latin.uix.settings.pages.DevLayoutList
import org.luxtype.inputmethod.latin.uix.settings.pages.DevThemeImportScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.DeveloperScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.HelpMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.HomeScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.HomeScreenLite
import org.luxtype.inputmethod.latin.uix.settings.pages.KeyboardAndTypingScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.KeyboardSettingsMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.LanguageSettingsLite
import org.luxtype.inputmethod.latin.uix.settings.pages.LanguagesScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.LongPressMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.MiscMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.NumberRowSettingMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.PredictiveTextMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.ProjectInfoView
import org.luxtype.inputmethod.latin.uix.settings.pages.ResizeMenuLite
import org.luxtype.inputmethod.latin.uix.settings.pages.ResizeScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.SearchScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.SelectLanguageScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.SelectLayoutsScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.themes.ThemeScreen
import org.luxtype.inputmethod.latin.uix.settings.pages.TypingSettingsMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.VoiceInputMenu
import org.luxtype.inputmethod.latin.uix.settings.pages.addModelManagerNavigation
import org.luxtype.inputmethod.latin.uix.settings.pages.buggyeditors.BuggyTextEditVariations
import org.luxtype.inputmethod.latin.uix.settings.pages.pdict.ConfirmDeleteExtraDictFileDialog
import org.luxtype.inputmethod.latin.uix.settings.pages.pdict.PersonalDictionaryLanguageList
import org.luxtype.inputmethod.latin.uix.settings.pages.pdict.PersonalDictionaryLanguageListForLocale
import org.luxtype.inputmethod.latin.uix.settings.pages.pdict.WordPopupDialogF
import org.luxtype.inputmethod.latin.uix.settings.pages.themes.DeleteCustomThemeDialog
import org.luxtype.inputmethod.latin.uix.urlDecode
import org.luxtype.inputmethod.latin.uix.urlEncode

// Utility function for quick error messages
fun NavHostController.navigateToError(title: String, body: String) {
    this.navigate("error/${title.urlEncode()}/${body.urlEncode()}")
}

fun NavHostController.navigateToInfo(title: String, body: String) {
    this.navigate("info/${title.urlEncode()}/${body.urlEncode()}")
}

val SettingsMenus = listOf(
    HomeScreenLite,
    LanguageSettingsLite,
    KeyboardSettingsMenu,
    NumberRowSettingMenu,
    TypingSettingsMenu,
    ResizeMenuLite,
    LongPressMenu,
    PredictiveTextMenu,
    BlacklistScreenLite,
    VoiceInputMenu,
    ActionsScreen,
    HelpMenu,
    MiscMenu,
    CreditsScreenLite,
    IMESettingsMenu
) + AllActions.mapNotNull { it.settingsMenu } + SettingsByLanguage.values

@Composable
fun SettingsNavigator(
    navController: NavHostController = rememberNavController()
) {
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = "home",
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable("home") { HomeScreen(navController) }
            composable("search") { SearchScreen(navController) }
            composable("languages") { LanguagesScreen(navController) }
            composable("addLanguage") { SelectLanguageScreen(navController) }
            composable("addLayout/{lang}") {
                SelectLayoutsScreen(
                    navController,
                    it.arguments?.getString("lang")?.urlDecode() ?: ""
                )
            }
            composable("pdict") {
                PersonalDictionaryLanguageList()
            }
            composable("pdict/{lang}") {
                PersonalDictionaryLanguageListForLocale(
                    navController,
                    it,
                    it.arguments?.getString("lang")?.urlDecode() ?: "all"
                )
            }
            dialog("pdictword/{lang}/{word}") {
                WordPopupDialogF(
                    locale = it.arguments?.getString("lang")?.urlDecode(),
                    selectedWord = it.arguments?.getString("word")?.urlDecode(),
                )
            }
            dialog("pdictdelete/{dict}") {
                ConfirmDeleteExtraDictFileDialog(it.arguments?.getString("dict")?.urlDecode()!!)
            }
            composable("advancedparams") { AdvancedParametersScreen(navController) }
            composable("actionEdit") { ActionEditorScreen(navController) }
            SettingsMenus.forEach { menu ->
                if(menu.registerNavPath) composable(menu.navPath) { UserSettingsMenuScreen(menu) }
            }
            composable("keyboardAndTyping") { KeyboardAndTypingScreen(navController) }
            composable("resize") { ResizeScreen(navController) }
            composable("themes") { ThemeScreen(navController) }
            composable("customTheme/{uri}") { CustomThemeScreen(it.arguments?.getString("uri") ?: "", navController) }

            composable("developer") { DeveloperScreen(navController) }
            composable("devtextedit") { DevEditTextVariationsScreen(navController) }
            composable("devbuggytextedit") { BuggyTextEditVariations(navController) }
            composable("devlayouts") { DevLayoutList(navController) }
            composable("devlayouteditor") { DevLayoutEditor(navController) }
            composable("devtheme") { DevThemeImportScreen(navController) }
            composable("devkeyboard") { DevKeyboardScreen(navController) }
            composable("devlayoutedit/{i}") {
                DevLayoutEdit(
                    navController,
                    it.arguments!!.getString("i")!!.toInt()
                )
            }
            composable("blacklist") { BlacklistScreen(navController) }
            composable("credits") { CreditsScreen(navController) }
            composable("exportingcfg") { ExportingMenu(navController) }
            dialog("deleteTheme/{name}") {
                DeleteCustomThemeDialog(it.arguments?.getString("name")?.urlDecode() ?: "", navController)
            }
            composable("credits/thirdparty/{idx}") {
                ProjectInfoView(
                    it.arguments?.getString("idx")?.toIntOrNull() ?: 0,
                    navController
                )
            }
            dialog("error/{title}/{body}") {
                ErrorDialog(
                    it.arguments?.getString("title")?.urlDecode()
                        ?: stringResource(R.string.settings_unknown_error_title),
                    it.arguments?.getString("body")?.urlDecode()
                        ?: stringResource(R.string.settings_unknown_error_subtitle),
                    navController
                )
            }
            dialog("info/{title}/{body}") {
                InfoDialog(
                    it.arguments?.getString("title")?.urlDecode() ?: "",
                    it.arguments?.getString("body")?.urlDecode() ?: "",
                    navController
                )
            }
            dialog("update") {
                UpdateDialog(navController = navController)
            }
            addModelManagerNavigation(navController)
        }
    }
}
