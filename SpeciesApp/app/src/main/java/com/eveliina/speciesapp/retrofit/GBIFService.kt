package com.eveliina.speciesapp.retrofit

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface GBIFService {
    @GET("dataset")
    suspend fun getOccurrenceData(
        @Query("country") country: String,
        @Query("type") type: String
    ): ResponseBody
}


