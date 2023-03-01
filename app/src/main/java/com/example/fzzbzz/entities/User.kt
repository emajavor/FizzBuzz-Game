package com.example.fzzbzz.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "userName")
    val userName: String,
    @NonNull
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "highscore")
    val highscore: Int,
    @NonNull
    @ColumnInfo(name = "email")
    val email: String

)