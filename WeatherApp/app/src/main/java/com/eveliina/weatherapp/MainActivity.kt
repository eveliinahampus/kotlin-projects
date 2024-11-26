package com.eveliina.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eveliina.weatherapp.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Now you can access views using binding.textViewCity, binding.textViewTemperature, etc.
    }
}


        // Observe weather data changes
        viewModel.weatherData.observe(this, { weatherData ->
            weatherData?.let {
                updateUI(weatherData)
            }
        })

        // Observe error state
        viewModel.error.observe(this, { error ->
            error?.let {
                // Handle error, e.g., show error message
            }
        })

        // Observe loading state
        viewModel.isLoading.observe(this, { isLoading ->
            isLoading?.let {
                if (isLoading) {
                    // Show loading indicator
                } else {
                    // Hide loading indicator
                }
            }
        })

        // Fetch weather data
        viewModel.fetchWeather("CityName")
    }

    private fun updateUI(weatherData: WeatherData) {
        binding.textViewCity.text = weatherData.name
        binding.textViewTemperature.text = "${weatherData.main.temp.toInt()}°C"
        val iconUrl = "https://openweathermap.org/img/w/${weatherData.weather[0].icon}.png"
        binding.imageViewWeatherIcon.load(iconUrl)
    }
}


