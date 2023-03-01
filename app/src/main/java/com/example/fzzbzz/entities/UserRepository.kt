package com.example.fzzbzz.entities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {
    //val getHighscores: MutableLiveData<List<User>> = userDao.getHighscores()
    val allUsers = MutableLiveData<List<User>>()
    val foundUser = MutableLiveData<User>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addUser(newUser: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.addUser(newUser)
        }
    }

    fun updateUserDetails(newUser: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.updateUserDetails(newUser)
        }
    }

    fun getAllUsers() {
        coroutineScope.launch(Dispatchers.IO) {
            allUsers.postValue(userDao.getAllUsers())
        }
    }

    /*suspend fun addUser(user: User){
        userDao.addUser(user)
    }*/

}