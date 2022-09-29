package com.example.app1

data class Film(
    val imageId: Int, val title: String, val description: String, val genre: String,
    val timeDuration: Int, val actors: List<String>, val rating: Double, val ageLimit: String)