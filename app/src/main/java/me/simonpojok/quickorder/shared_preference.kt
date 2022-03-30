package me.simonpojok.quickorder

import android.content.Context

const val USER_NAME_KEY = "USER_NAME_KEY"
const val APP_PREF_FILE_NAME = "prorder"

fun saveUserName(context: Context, username: String) {
    val sharedPref = context.getSharedPreferences(APP_PREF_FILE_NAME, Context.MODE_PRIVATE)
    with(sharedPref.edit()) {
        putString(USER_NAME_KEY, username)
        apply()
    }
}

fun getUserName(context: Context): String {
    val sharedPref = context.getSharedPreferences(APP_PREF_FILE_NAME, Context.MODE_PRIVATE)
    return sharedPref.getString(USER_NAME_KEY, "") ?: ""
}
