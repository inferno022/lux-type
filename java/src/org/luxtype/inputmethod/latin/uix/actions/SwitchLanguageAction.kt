package org.luxtype.inputmethod.latin.uix.actions

import org.luxtype.inputmethod.latin.R
import org.luxtype.inputmethod.latin.Subtypes
import org.luxtype.inputmethod.latin.uix.Action


val SwitchLanguageAction = Action(
    icon = R.drawable.globe,
    name = R.string.show_language_switch_key,
    simplePressImpl = { manager, _ ->
        if(!Subtypes.switchToNextLanguage(manager.getContext(), 1)) {
            manager.openInputMethodPicker()
        }
    },
    altPressImpl = { manager, _ ->
        manager.openInputMethodPicker()
    },
    windowImpl = null,
)
