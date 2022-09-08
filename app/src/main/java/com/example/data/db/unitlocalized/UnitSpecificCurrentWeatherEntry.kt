package com.example.data.db.unitlocalized

import androidx.room.ColumnInfo

interface UnitSpecificCurrentWeatherEntry {


    //  //  abstract val conditionIconUrl: String
//    abstract val visibilityDistance: Double
//    abstract val windDirection: String
//    abstract val precipitationVolume: Double
//    abstract val conditionText: String
//    abstract val feelsLikeTemperature: Double
    val temperature: Int
    val windSpeed: Int
    val windDegree: Int
    val precip: Int
   // val feelsLikeTemperature: Int
    val cloudcover: Int

//    val temperature: Double
//    val conditionText: String
//    val conditionIconUrl: String
//    val windSpeed: Double
//    val windDirection: String
//    val precipitationVolume: Double
//    val feelsLikeTemperature: Double
//    val visibilityDistance: Double

}