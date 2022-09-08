package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.db.entity.Location
import com.example.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import com.example.data.db.unitlocalized.WeatherLocationDao

interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean): LiveData<out  UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<Location>




}