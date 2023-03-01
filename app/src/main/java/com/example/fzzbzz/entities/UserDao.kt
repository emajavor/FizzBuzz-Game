package com.example.fzzbzz.entities

import androidx.room.*

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table WHERE userName = :userId")
    fun findUserById(empId: String): User

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>

    @Update
    suspend fun updateUserDetails(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}