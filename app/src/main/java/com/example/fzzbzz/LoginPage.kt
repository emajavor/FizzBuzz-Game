package com.example.fzzbzz

import android.graphics.Paint.Align
import android.widget.Button
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginPage(navController: NavController){

    //val image = ImageBitmap.imageResource(id = )
    val emailValue = remember{ mutableStateOf("") }
    val passwordValue = remember{ mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    //val focusRequester = remember { FocusRequester() }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.TopCenter){

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(weight =1f, fill = false)
            ) {
                Text(text = "Sign In", style = TextStyle(fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                    fontSize = 38.sp)
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(value = emailValue.value, onValueChange = {emailValue.value = it},
                        label = { Text(text = "Email Adress") },
                        singleLine = true ,
                        modifier = Modifier.fillMaxWidth(0.8f)

                    )
                    OutlinedTextField(
                        value = passwordValue.value, onValueChange = { passwordValue.value = it},
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            } ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password_eye),
                                    contentDescription = null,
                                    tint = if (passwordVisibility.value) Color.Blue else Color.Gray
                                    //imageVector = painterResource(id = R.drawable.password_eye ),
                                    //imageVector = ImageVector.vectorResource(id = R.drawable.password_eye),
                                )
                            }
                        },
                        label = { Text(text = "Password")},
                        placeholder = { Text(text = "Password")},
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                        //.focusRequester(focusRequester = focusRequester),
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = {
                        navController.navigate(Screen.MainScreen.route)
                    },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)) {
                        Text(text = "Sign In", fontSize = 20.sp)

                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Create An Account",
                        modifier = Modifier.clickable(onClick = {
                            //navController.navigate(Screen.RegisterApplication.route)
                            navController.navigate("register_page"){
                                popUpTo = navController.graph.startDestinationId
                                launchSingleTop = true
                            }
                        }))


                }
            }


        }
    }
}