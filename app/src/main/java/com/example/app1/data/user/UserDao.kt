package com.example.app1.data.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun  readAllData(): List<User>

    @Query("SELECT * FROM user_table WHERE id = :user_id")
    fun  getUser(user_id: Int): User

    @Query("SELECT * FROM user_table WHERE login = :user_login")
    fun  getUserByLogin(user_login: String): User
}