package com.example.calculadorfonoma.common

import android.content.SharedPreferences
import androidx.core.content.edit


class CustomSharedPreferences {

    companion object {



        /*
        @Volatile private var instance: CustomSharedPreferences? = null
        private val lock = Any()

        operator fun invoke(context: Context) : CustomSharedPreferences = instance ?: synchronized(lock) {
            instance ?: makeCustomSharedPreferences(context).also {
                instance = it
            }
        }

        private fun makeCustomSharedPreferences(context: Context) : CustomSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }

         */
    }


    private val PREFERENCES_TIME = "preferences_time"
    private var sharedPreferences: SharedPreferences? = null

    fun saveTime(time: Long) {
        sharedPreferences?.edit(commit = true){
            putLong(PREFERENCES_TIME,time)
        }
    }

    fun getTime() = sharedPreferences?.getLong(PREFERENCES_TIME,0)

}