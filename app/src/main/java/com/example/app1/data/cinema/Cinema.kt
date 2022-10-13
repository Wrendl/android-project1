package com.example.app1.data.cinema

import java.io.Serializable

data class Cinema (
    val imageId: Int,
    val title: String,
    val address: String,
    val description: String
    ): Serializable