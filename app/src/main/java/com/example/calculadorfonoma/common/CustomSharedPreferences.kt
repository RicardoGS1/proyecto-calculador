package com.example.calculadorfonoma.common

import android.content.SharedPreferences
import com.example.calculadorfonoma.common.Constant.PREFERENCES_TIME
import javax.inject.Inject


class CustomSharedPreferences @Inject constructor(private val sharedPref: SharedPreferences)
{
    fun saveTime(time: Long)
    {
        sharedPref.edit().putLong(PREFERENCES_TIME, time).apply()
    }

    fun getTime() = sharedPref.getLong(PREFERENCES_TIME, 0)
}