package com.example.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.db.entity.CURRENT_WEATHER_ID
import com.example.data.db.entity.Current
import com.example.data.db.unitlocalized.ImpericalCurrentWeatherEntry
import com.example.data.db.unitlocalized.MetricCurrentWeatherEntry
import kotlinx.coroutines.Deferred
import retrofit2.http.Query


@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: Current)

    @androidx.room.Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @androidx.room.Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImpericalCurrentWeatherEntry>
}