package com.example.searcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantsearcher.Models.Restaurants
import com.example.searcher.R
import com.example.restaurantsearcher.ui.theme.RestaurantSearcherTheme
import com.example.restaurantsearcher.data.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantSearcherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    s_bar()
                }
            }
        }
    }
}

@Composable
fun s_bar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(text = "Restaurant name or a Dish", fontSize = 20.sp) },
        modifier = Modifier
            .wrapContentHeight(Alignment.Top)
            .padding(top = 25.dp, start = 7.dp, end = 7.dp)
            .width(10.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        shape = RoundedCornerShape(30.dp),
        singleLine = true
    )
}

@Composable
fun Cards(restaurant: Restaurants,modifier: Modifier = Modifier) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(190.dp)
            .padding(start = 5.dp, end = 5.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(restaurant.imageResourceId),
                contentDescription = "Restaurant image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(132.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        text = LocalContext.current.getString(restaurant.name),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = LocalContext.current.getString(restaurant.Description),
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Cursive 
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = LocalContext.current.getString(restaurant.rating),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Text(
                        text = "Rs. ${restaurant.cost.toString()}",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun List(List: List<Restaurants>,modifier: Modifier = Modifier) {
    LazyColumn {
        items(List) { restaurant ->
            Cards(restaurant)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RestaurantSearcherTheme {
//        s_bar()
        List(List = DataSource().loadRestaurants())
    }
}