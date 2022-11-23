package com.example.app1.data.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: List<User>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun getUser(id: Int): User {
        return repository.getUser(id)
    }

    fun getUserByLogin(user_login: String): User {
        return repository.getUserByLogin(user_login)
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun addCash(user_login: String) {
        repository.addCash(user_login)
    }

    fun deleteCash(user_login: String) {
        repository.deleteCash(user_login)
    }
}