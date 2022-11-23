package com.example.app1.data.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: List<User> = userDao.readAllData()

    fun getUser(user_id: Int): User {
        return userDao.getUser(user_id)
    }

    fun getUserByLogin(user_login: String): User {
        return userDao.getUserByLogin(user_login)
    }

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    fun addCash(user_login: String) {
        userDao.addCash(user_login)
    }

    fun deleteCash(user_login: String) {
        userDao.deleteCash(user_login)
    }
}