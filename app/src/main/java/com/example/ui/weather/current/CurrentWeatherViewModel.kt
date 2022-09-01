package com.example.ui.weather.current

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import com.example.data.provider.UnitProvider
import com.example.data.repository.ForecastRepository
import com.example.internal.UnitSystem
import com.example.internal.lazyDeferred
import kotlinx.coroutines.*

class CurrentWeatherViewModel(

    private val forecatRepository: ForecastRepository,
   unitProvider: UnitProvider

) : ViewModel() {

    private val unitSystem=unitProvider.getUnitSystem() //get from setting later

    val isMetric:Boolean
    get()= unitSystem==UnitSystem.METRIC



    val weather by lazyDeferred{
        forecatRepository.getCurrentWeather(isMetric) ?: ""
    }

    val weatherLocation by lazyDeferred{
        forecatRepository.getWeatherLocation() ?:""
    }


}


