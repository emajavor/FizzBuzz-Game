package com.example.fzzbzz

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.fzzbzz.ui.theme.FzzBzzTheme
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        Thread.sleep(2000)
        installSplashScreen()
        setContent {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "FizzBuzz Game",
                    color = Color.Black,
                    textAlign = TextAlign.Center

                )
            })
            Navigation()




        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FzzBzzTheme {

    }
}