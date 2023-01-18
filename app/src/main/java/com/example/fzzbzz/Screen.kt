package com.example.fzzbzz

sealed class Screen(val route: String){
    object MainScreen : Screen("main-screen")
    object GameOverScreen : Screen("game-over-screen")
}
