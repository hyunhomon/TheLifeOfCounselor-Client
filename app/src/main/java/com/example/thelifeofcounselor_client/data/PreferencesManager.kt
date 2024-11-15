package com.example.thelifeofcounselor_client.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "preferences"
        private const val KEY_USER = "user"
    }

    fun getUser(): String {
        return sharedPreferences.getString(KEY_USER, "") ?: ""
    }
    fun setUser(user: String) {
        sharedPreferences.edit().putString(KEY_USER, user).apply()
    }
}