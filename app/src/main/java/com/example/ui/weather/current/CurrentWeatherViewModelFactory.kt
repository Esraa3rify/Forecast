package com.example.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.provider.UnitProvider
import com.example.data.repository.ForecastRepository

class CurrentWeatherViewModelFactory (

    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
        ): ViewModelProvider.NewInstanceFactory(){



    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository, unitProvider) as T
    }
}