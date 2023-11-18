package com.example.calculadorfonoma.di.sharedpref

import android.content.Context
import android.content.SharedPreferences
import com.example.calculadorfonoma.common.Constant.PREFERENCES_TIME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {
    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_TIME, Context.MODE_PRIVATE)
    }
}
