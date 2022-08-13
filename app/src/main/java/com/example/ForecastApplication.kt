package com.example

import android.app.Application
import android.content.Context
import android.location.LocationProvider
import com.example.data.ApixuWeatherApiService
import com.example.data.db.ForecastDatabase
import com.example.data.network.WeatherNetworkDataSource
import com.example.data.network.WeatherNetworkDataSourceImpl
import com.example.data.network.dataConnectivityInterceptor.ConnectivityInterceptor
import com.example.data.network.dataConnectivityInterceptor.ConnectivityInterceptorImpl
import com.example.data.repository.ForecastRepository
import com.example.data.repository.ForecastRepositoryImpl
import com.google.android.gms.location.LocationServices
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(),KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        //bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
      //  bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
      //  bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance()) }


    }
}