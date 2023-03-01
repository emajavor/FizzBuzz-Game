package com.example.fzzbzz.entities

import android.app.Application
import android.view.KeyEvent.DispatcherState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository):
    ViewModel() {

    val userList: LiveData<List<User>> = userRepository.allUsers
    val foundUser: LiveData<User> = userRepository.foundUser

    fun getAllUsers(){
        userRepository.getAllUsers()
    }

    fun addUser(user: User) {
        userRepository.addUser(user)
        getAllUsers()
    }

    fun updateUserDetails(user: User) {
        userRepository.updateUserDetails(user)
        getAllUsers()
    }

    /*private val getHighscores: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository((userDao))
        getHighscores = repository.getHighscores
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }*/
}

