package com.example.clean.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun hello(nav: NavController) {
    Scaffold(
        topBar = { Text(text = "App") }
    ) { it ->
        Column(Modifier.padding(it)) {
            Image(
                painter = rememberImagePainter(data = "https://techcrunch.com/wp-content/uploads/2022/11/GettyImages-491311400.jpg"),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = { nav.navigate("detail") }) {
                Text(text = "Home Page")
            }
        }
    }
}