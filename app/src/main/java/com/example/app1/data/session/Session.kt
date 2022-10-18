package com.example.app1.data.session

import java.io.Serializable

class Session (
    val id: Int,
    val time: String,
    val filmTitle: String,
    val filmId: Int,
    val cinemaTitle: String,
    val cinemaId: Int,
    val language: String,
    val priceAdult: String,
    val priceStud: String,
    val priceChild: String,
    val priceVip: String,
    val hallId: Int
): Serializable {
}