package com.eveliina.poetryapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PoetryApiService {
    @GET("author,{author};title,{title}/author,title")
    fun getPoemsByAuthorAndTitle(
        @Path("author") author: String,
        @Path("title") title: String
    ): Call<List<Poem>>
}


