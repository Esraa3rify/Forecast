package com.example.internal

import com.example.ui.weather.current.CurrentWeatherFragment
import kotlinx.coroutines.*



fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}