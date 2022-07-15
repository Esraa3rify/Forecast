package com.example.data.network.response

import com.example.data.db.entity.Current
import com.example.data.db.entity.Location
import com.example.data.db.entity.Request


data class CurrentWeatherResponce(
    val current: Current,
    val location: Location,
    val request: Request
)