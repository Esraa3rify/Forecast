package com.example.data.network.response

import com.example.data.db.entity.Current
import com.example.data.db.entity.Location
import com.example.data.db.entity.Request
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponce(
    @SerializedName("current")
    val current: Current,

    val location: Location,//weatherLocation
    val request: Request

)