package com.example.clean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clean.data.constants.constants
import com.example.clean.domain.entities.Page
import com.example.clean.presentation.ui.hello
import com.example.clean.presentation.ui.home
import com.example.clean.presentation.ui.onBoardingPage
import com.example.clean.presentation.viewmodel.news_viewmodel
import com.example.clean.ui.theme.CleanTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = ViewModelProvider(this).get(news_viewmodel::class.java)
                    val newsData = viewModel.get_data().value
                    var nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "home") {
                        composable("test") {
                            hello(nav = nav)
                        }
                        composable("home") {
                            home(newsData = newsData!!, nav = nav)
                        }
                        composable("detail") {
                            onBoardingPage(page = constants.page, nav = nav)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanTheme {
        Greeting("Android")
    }
}