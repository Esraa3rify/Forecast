package com.example.data.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager




   // abstract val preferences: Any

    abstract class PreferenceProvider(context: Context) {
        private val appContext = context.applicationContext

        val preferences: SharedPreferences
            get() = PreferenceManager.getDefaultSharedPreferences(appContext)
    }
