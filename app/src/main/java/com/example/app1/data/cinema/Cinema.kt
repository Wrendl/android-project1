package com.example.app1.data.cinema

import java.io.Serializable

data class Cinema (
    val id: Int,
    val imageId: Int,
    val title: String,
    val address: String,
    val description: String
    ): Serializable