package com.example.data.provider

import com.example.data.db.entity.Location

interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: Location): Boolean
    suspend fun getPreferredLocationString(): String
}