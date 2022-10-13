package com.example.app1.data.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: List<User> = userDao.readAllData()

//    val getUser: User = userDao.getUser(user_id: Int)
    fun getUser(): User {
        val list = userDao.readAllData()
        return list[0]
    }

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}