package com.alexandreobsilva.a12passosnamauricio

import android.content.Context
import android.content.SharedPreferences


class AppUtil {

    companion object {

        fun salvarIdUsuario(context: Context, uiid: String) {
            val preferences: SharedPreferences =
                context.getSharedPreferences("APP", Context.MODE_PRIVATE)
            preferences.edit().putString("UIID", uiid).apply()
        }

//        fun getIdUsuario(context: Context): String? {
//            val preferences: SharedPreferences =
//                context.getSharedPreferences("APP", Context.MODE_PRIVATE)
//            return preferences.getString("UIID", "")
//        }
    }
}