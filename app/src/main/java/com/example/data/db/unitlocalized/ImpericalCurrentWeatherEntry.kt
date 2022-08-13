package com.example.data.db.unitlocalized

import androidx.room.ColumnInfo

data class ImpericalCurrentWeatherEntry(

    @ColumnInfo("temperature")
    override val temperature: Int,
    @ColumnInfo("windSpeed")
    override val windSpeed: Int,
    @ColumnInfo("windDegree")
    override val windDegree: Int,
    @ColumnInfo("precip")
    override val precip: Int,
    @ColumnInfo(" feelslike")
    override val feelsLikeTemperature: Int,
    @ColumnInfo("cloudcover")
    override val cloudcover: Int

) :UnitSpecificCurrentWeatherEntry