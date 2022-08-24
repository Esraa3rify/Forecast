package com.example.ui.weather.current

import androidx.lifecycle.ViewModel
import com.example.data.repository.ForecastRepository
import com.example.internal.UnitSystem
import com.example.internal.lazyDeferred
import kotlinx.coroutines.*

class CurrentWeatherViewModel(  val forecatRepository: ForecastRepository

) : ViewModel() {

    private val unitSystem=UnitSystem.METRIC //get from setting later

    val isMetric:Boolean
    get()= unitSystem==UnitSystem.METRIC



    val weather by lazyDeferred{
        forecatRepository.getCurrentWeather(isMetric) ?:""
    }


}


