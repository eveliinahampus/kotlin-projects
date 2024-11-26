package com.eveliina.poetryapp

import com.google.gson.annotations.SerializedName

data class Poem(
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("lines") val lines: List<String>
)

