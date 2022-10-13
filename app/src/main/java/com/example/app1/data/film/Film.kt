package com.example.app1.data.film

import java.io.Serializable

data class Film(
    val imageId: Int,
    val title: String,
    val description: String,
    val genre: String,
    val timeDuration: String,
    val actors: String,
    val rating: Double,
    val ageLimit: String):
    Serializable