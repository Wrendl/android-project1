package com.example.app1.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val login: String,
    val password: String,
    val mail: String,
//    val role: String //user, admin
)