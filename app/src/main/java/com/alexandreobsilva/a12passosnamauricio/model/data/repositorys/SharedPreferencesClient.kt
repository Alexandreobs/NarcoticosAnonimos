package com.alexandreobsilva.a12passosnamauricio.model.data.repositorys

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesClient (private val context: Context){
    private val prefs: SharedPreferences
        get()=context.getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE)

    fun setString(key: String,value: String){
        prefs.edit().putString(key,value).apply()
    }

    fun getString(key: String)=
        prefs.getString(key, "")

    companion object{

        private const val PREFS_FILENAME="vitoria_anonima"
    }
}