package com.eveliina.weatheroulu

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherService {
    @GET("wfs?request=getFeature&storedquery_id=fmi::observations::weather::timevaluepair&place=oulu&timestep=10&parameters=temperature")
    suspend fun getWeather(): WeatherResponse

    companion object {
        private const val BASE_URL = "https://opendata.fmi.fi/"

        fun create(): WeatherService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WeatherService::class.java)
        }
    }
}

