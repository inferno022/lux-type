package org.luxtype.inputmethod.latin.uix.settings.pages

import android.content.Intent
import androidx.compose.runtime.Composable
import org.luxtype.inputmethod.latin.R
import org.luxtype.inputmethod.latin.uix.AUDIO_FOCUS
import org.luxtype.inputmethod.latin.uix.CAN_EXPAND_SPACE
import org.luxtype.inputmethod.latin.uix.DISALLOW_SYMBOLS
import org.luxtype.inputmethod.latin.uix.ENABLE_SOUND
import org.luxtype.inputmethod.latin.uix.PREFER_BLUETOOTH
import org.luxtype.inputmethod.latin.uix.USE_PERSONAL_DICT
import org.luxtype.inputmethod.latin.uix.USE_SYSTEM_VOICE_INPUT
import org.luxtype.inputmethod.latin.uix.USE_VAD_AUTOSTOP
import org.luxtype.inputmethod.latin.uix.VERBOSE_PROGRESS
import org.luxtype.inputmethod.latin.uix.settings.NavigationItemStyle
import org.luxtype.inputmethod.latin.uix.settings.UserSettingsMenu
import org.luxtype.inputmethod.latin.uix.settings.useDataStoreValue
import org.luxtype.inputmethod.latin.uix.settings.userSettingNavigationItem
import org.luxtype.inputmethod.latin.uix.settings.userSettingToggleDataStore

private val visibilityCheckNotSystemVoiceInput = @Composable {
    useDataStoreValue(USE_SYSTEM_VOICE_INPUT) == false
}

val VoiceInputMenu = UserSettingsMenu(
    title = R.string.voice_input_settings_title,
    navPath = "voiceInput", registerNavPath = true,
    settings = listOf(
        userSettingToggleDataStore(
            title = R.string.voice_input_settings_disable_builtin_voice_input,
            subtitle = R.string.voice_input_settings_disable_builtin_voice_input_subtitle,
            setting = USE_SYSTEM_VOICE_INPUT
        ),

        //if(!systemVoiceInput.value) {
        userSettingToggleDataStore(
            title = R.string.voice_input_settings_indication_sounds,
            subtitle = R.string.voice_input_settings_indication_sounds_subtitle,
            setting = ENABLE_SOUND
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        /*
        userSettingToggleDataStore(
            title = R.string.voice_input_settings_verbose_progress,
            subtitle = R.string.voice_input_settings_verbose_progress_subtitle,
            setting = VERBOSE_PROGRESS
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),
         */

        userSettingToggleDataStore(
            title = R.string.voice_input_settings_use_personal_dict,
            subtitle = R.string.voice_input_settings_use_personal_dict_subtitle,
            setting = USE_PERSONAL_DICT
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        userSettingToggleDataStore(
            title = R.string.voice_input_settings_use_bluetooth_mic,
            subtitle = R.string.voice_input_settings_use_bluetooth_mic_subtitle,
            setting = PREFER_BLUETOOTH
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        userSettingToggleDataStore(
            title = R.string.voice_input_settings_audio_focus,
            subtitle = R.string.voice_input_settings_audio_focus_subtitle,
            setting = AUDIO_FOCUS
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        userSettingToggleDataStore(
            title = R.string.voice_input_settings_suppress_symbols,
            setting = DISALLOW_SYMBOLS
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        userSettingToggleDataStore(
            title = R.string.voice_input_settings_long_form,
            subtitle = R.string.voice_input_settings_long_form_subtitle,
            setting = CAN_EXPAND_SPACE
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        userSettingToggleDataStore(
            title = R.string.voice_input_settings_autostop_vad,
            subtitle = R.string.voice_input_settings_autostop_vad_subtitle,
            setting = USE_VAD_AUTOSTOP
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),

        userSettingNavigationItem(
            title = R.string.voice_input_settings_change_models,
            subtitle = R.string.voice_input_settings_change_models_subtitle,
            style = NavigationItemStyle.Misc,
            navigateTo = "languages"
        ).copy(visibilityCheck = visibilityCheckNotSystemVoiceInput),
        //}
    )
)
