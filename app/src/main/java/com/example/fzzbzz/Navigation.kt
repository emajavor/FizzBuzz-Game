package com.example.fzzbzz

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val fontFamily = FontFamily(
    Font(R.font.lilitaone_regular)
)


@Composable
fun Navigation(){
    val navController = rememberNavController()
    navController.popBackStack()
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher


    NavHost(navController = navController, startDestination = Screen.LoginApplication.route){
        composable(route = Screen.LoginApplication.route){
            LoginApplication(navController = navController)
        }
        composable(route = Screen.RegisterApplication.route){
            RegisterApplication(navController = navController)
        }
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.GameOverScreen.route
        ){
            GameOverScreen(navController = navController)
        }
    }
}

@Composable
fun LoginApplication(navController: NavController){
    LoginPage(navController)

}

@Composable
fun RegisterApplication(navController: NavController){
    RegisterPage(navController)
}


@Composable
fun MainScreen(navController: NavController){
    var state: MutableState<Int> = remember { mutableStateOf(1) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.padding(60.dp)

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            //modifier = Modifier.fillMaxSize() ,
            text = "${state.value}",
            fontSize = 120.sp,
            fontFamily = fontFamily
        )


        Spacer(modifier = Modifier.height(50.dp))

        Row(
        ) {
            val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(140.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =  Color(60,82,145),
                    contentColor = Color.White),
                onClick = {

                if (state.value % 3 == 0 && state.value % 5 != 0){
                    state.value += 1

                }
                else
                    navController.navigate(Screen.GameOverScreen.route)



                }
            ) {
                Text(text = "FIZZ")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(140.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =  Color(60,82,145),
                    contentColor = Color.White),
                onClick = {
                if (state.value % 5 == 0 && state.value % 3 != 0){
                    state.value += 1
                }
                else
                    navController.navigate(Screen.GameOverScreen.route)

            }
            ) {
                Text(text = "BUZZ")
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Row() {
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(140.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =  Color(60,82,145),
                    contentColor = Color.White),
                onClick = {
                if (state.value % 5 == 0 && state.value % 3 == 0){
                    state.value += 1
                }
                else
                    navController.navigate(Screen.GameOverScreen.route)

            }
            ) {
                Text(text = "FIZZBUZZ")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(modifier = Modifier
                .height(40.dp)
                .width(140.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =  Color(60,82,145),
                    contentColor = Color.White),
                onClick = {
                if (state.value % 5 != 0 && state.value % 3 != 0){
                    state.value += 1
                }
                else
                    navController.navigate(Screen.GameOverScreen.route)

            }
            ) {
                Text(text = "NEXT")
            }
        }



    }
}

@Composable
fun GameOverScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
    ) {
        Text(
            text = "GAME OVER",
            fontSize = 55.sp,
            fontFamily = fontFamily
        )
        Spacer(modifier = Modifier.height(60.dp))
        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor =  Color(60,82,145),
                contentColor = Color.White),
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            }) {
            Text(text = "PLAY AGAIN")
        }


    }

}