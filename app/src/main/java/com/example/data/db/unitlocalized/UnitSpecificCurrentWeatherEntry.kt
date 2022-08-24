package com.example.data.db.unitlocalized

import androidx.room.ColumnInfo

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Int
    val windSpeed: Int
    val windDegree: Int
    val precip: Int
   // val feelsLikeTemperature: Int
    val cloudcover: Int

}