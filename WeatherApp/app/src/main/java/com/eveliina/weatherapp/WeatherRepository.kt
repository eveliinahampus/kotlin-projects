package com.eveliina.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    private val weatherService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    suspend fun getWeather(city: String): WeatherData {
        // Replace "API_KEY" with your actual OpenWeatherMap API key
        return weatherService.getWeather(city, "API_KEY")
    }
}
