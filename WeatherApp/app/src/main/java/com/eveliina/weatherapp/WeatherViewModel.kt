package com.eveliina.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class WeatherViewModel : ViewModel() {

    private val weatherRepository = WeatherRepository()

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData> = _weatherData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchWeather(city: String) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val weatherData = weatherRepository.getWeather(city)
                _weatherData.postValue(weatherData)
            } catch (e: Exception) {
                _error.postValue("Error fetching weather data")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}
