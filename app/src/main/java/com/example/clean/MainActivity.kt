package com.example.clean

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clean.data.api.Article
import com.example.clean.data.api.news
import com.example.clean.data.constants.constants
import com.example.clean.domain.entities.Page
import com.example.clean.presentation.ui.hello
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
                    var nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "home") {
                        composable("test") {
                            hello(nav = nav)
                        }
                        composable("home") {
                            home(nav = nav)
                        }
                        composable("detail") {
                            onBoardingPage(page = constants.page, nav = nav)
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun home(
        nav: NavController
    ) {
        val viewModel = ViewModelProvider(this).get(news_viewmodel::class.java)
        val dataList by viewModel.get_data().observeAsState()

        LazyColumn {
            var new: List<Article> = dataList?.articles ?: emptyList()
            items(new) { article ->
                val page = Page(article.title, article.description, article.urlToImage)
                Card(modifier = Modifier.padding(vertical = 5.dp),
                    onClick = {
                        constants.page = page
                        nav.navigate("detail")
                    }) {
                    Card {
                        Column {
                            Text(
                                text = article.author,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                            Text(text = article.url)
                        }
                    }
                }
            }
        }
    }
}

//    @Composable
//    fun Greeting(name: String, modifier: Modifier = Modifier) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier,
//            textAlign = TextAlign.Center
//        )
//    }
//
//    @Preview(showBackground = true)
//    @Composable
//    fun GreetingPreview() {
//        CleanTheme {
//            Greeting("Android")
//        }
//    }
