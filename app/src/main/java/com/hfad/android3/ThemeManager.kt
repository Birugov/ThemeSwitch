package com.hfad.android3

import android.content.Context
import android.content.SharedPreferences

class ThemeManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(Constants.THEME_PREFS, Context.MODE_PRIVATE)

    fun saveTheme(token: String) {
        val editor = prefs.edit()
        editor.putString(Constants.THEME_VALUE, token)
        editor.apply()
    }

    fun fetchTheme(): String? {
        return prefs.getString(Constants.THEME_VALUE, null)
    }

    fun deleteTheme() {
        val editor = prefs.edit()
        editor.remove(Constants.THEME_VALUE)
        editor.apply()
    }
}
