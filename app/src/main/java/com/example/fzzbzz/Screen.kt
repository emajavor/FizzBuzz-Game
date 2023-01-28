package com.example.fzzbzz

sealed class Screen(val route: String){
    object LoginApplication : Screen("login-application")
    object RegisterApplication : Screen("register_page")
    object MainScreen : Screen("main-screen")
    object GameOverScreen : Screen("game-over-screen")
}
