package com.example.data.network

import androidx.lifecycle.LiveData
import com.example.data.network.response.CurrentWeatherResponce


interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponce>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )

}