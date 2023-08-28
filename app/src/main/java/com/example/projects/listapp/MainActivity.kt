package com.example.projects.listapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.projects.listapp.ui.theme.ListAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    DisplayBrands()
                }
            }
        }
    }
}

@Composable
fun PageTitle(name: String) {
    //Text(text = "Hello $name!")
    Text(text = name, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp), color = Color.Green)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListAppComposeTheme {
        PageTitle("Android")
    }
}

@Composable
fun DisplayBrands() {

    // List of strings with shoe brands
    val itemsToShow = listOf(
        "Addidas", "Nike", "Louis Vuitton", "Reebok", "Under Amour", "Lacoste", "New Balance"
    )
    // on below line we are
    // creating a simple column
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PageTitle("Popular Shoe Brands")

        // Use lazy column to show a listview listview.
        LazyColumn {
            // on below line we are populating items for listview.

            items(itemsToShow) { brand ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = MaterialTheme.colors.surface,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(), elevation = 10.dp
                ) {
                    Text(brand, modifier = Modifier.padding(15.dp), textAlign = TextAlign.Center)
                }


//                Text(brand, modifier = Modifier.padding(15.dp), textAlign = TextAlign.Center)
//                Divider()
            }
        }
    }
}