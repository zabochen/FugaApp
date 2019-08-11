package com.zabochen.data.preferences

import android.content.SharedPreferences

const val SWITCH_STATE_KEY = "switch_state_key"

class AppPreferences(sharedPreferences: SharedPreferences) {

    var blackThemeState by PreferencesDelegate<Boolean>(sharedPreferences, SWITCH_STATE_KEY, false)

}