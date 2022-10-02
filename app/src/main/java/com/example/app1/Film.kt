package com.example.app1

import java.io.Serializable

data class Film(
    val imageId: Int, val title: String, val description: String, val genre: String,
    val timeDuration: Int, val actors: List<String>, val rating: Double, val ageLimit: String):
    Serializable