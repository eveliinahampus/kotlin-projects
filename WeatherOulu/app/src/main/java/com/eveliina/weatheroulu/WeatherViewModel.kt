package com.eveliina.weatheroulu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherService: WeatherService) : ViewModel() {
    private val _weatherData = MutableLiveData<Double>()
    val weatherData: LiveData<Double> = _weatherData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.value = throwable.message
        _loading.value = false
    }

    fun fetchWeather() {
        _loading.value = true
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = weatherService.getWeather()
                val location = response.location
                val temperature = response.temperature
                val humidity = response.humidity
                val windSpeed = response.windSpeed

                val weatherResponse = WeatherResponse(
                    location,
                    temperature,
                    humidity,
                    windSpeed
                )
                _weatherData.postValue(weatherResponse)
            } catch (e: Exception) {
                _error.postValue(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }
