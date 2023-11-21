package com.example.clean.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.clean.R
import com.example.clean.data.constants.constants
import com.example.clean.domain.entities.Page

@Composable
fun onBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
    nav: NavController
) {
    constants.page = Page(
        "Descent",
        "A caving expedition goes horribly wrong, as the explorers become trapped and ultimately pursued by a strange breed of predators.",
        "https://techcrunch.com/wp-content/uploads/2022/11/GettyImages-491311400.jpg"
    )
    Column {
        Button(onClick = { nav.popBackStack() }) {
            Text(text = "Return")
        }
        Image(
            painter = rememberImagePainter(data = page.image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(modifier = Modifier.padding(horizontal = 5.dp)) {
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item {
                Text(
                    text = page.title,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                )
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item { Text(text = page.description) }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun test() {

}