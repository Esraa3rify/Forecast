package com.example.data.provider

import com.example.data.db.entity.Location

class LocationProviderImpl : LocationProvider {
    override suspend fun hasLocationChanged(lastWeatherLocation: Location): Boolean {
        TODO("Not yet implemented")
        return true
    }

    override suspend fun getPreferredLocationString(): String {
        TODO("Not yet implemented")
        return "Los Angeles"
    }
}