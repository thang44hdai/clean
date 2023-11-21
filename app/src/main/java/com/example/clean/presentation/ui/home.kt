package com.example.clean.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.clean.data.api.news
import com.example.clean.data.constants.constants
import com.example.clean.domain.entities.Page
import com.example.clean.presentation.viewmodel.news_viewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home(
    newsData: news,
    nav: NavController
) {
    Scaffold(
        topBar = {
            Text(text = "News")
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(newsData.articles.size) {
                val new = newsData.articles[it]
                val page = Page(new.title, new.description, new.urlToImage)
                Button(modifier = Modifier.padding(vertical = 5.dp),
                    onClick = {
                        constants.page = page
                        nav.navigate("detail")


                    }) {
                    Card() {
                        Column {
                            Text(
                                text = new.author,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                            Text(text = new.url)
                        }
                    }
                }
            }
        }
    }

}

