package com.fazztrack.bcasyariah.utils

import android.content.Context
import android.content.SharedPreferences

class SharePrefHelper(context: Context) {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String){
        sharedPref.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String{
        return sharedPref.getString(TOKEN_KEY, null) ?: ""
    }

    fun saveName(name: String) {
        sharedPref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName(): String {
        return sharedPref.getString(NAME_KEY, null) ?: ""
    }

    fun deleteName() {
        sharedPref.edit().remove(NAME_KEY).apply()
    }

    fun clearDataPref(){
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    companion object{
        const val TOKEN_KEY = "token_key"
        const val PREF_NAME = "pref_name"
        const val NAME_KEY = "name_key"
    }

}
