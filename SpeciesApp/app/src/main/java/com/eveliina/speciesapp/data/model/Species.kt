package com.eveliina.speciesapp.data.model

data class Species(
    val name: String,
    val kingdom: String,
    val phylum: String,
    val clazz: String,
    val order: String,
    val family: String,
    val genus: String,
    val imageUrl: String? // Nullable image URL
)

