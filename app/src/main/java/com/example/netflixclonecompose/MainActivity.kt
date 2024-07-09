package com.example.netflixclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclonecompose.ui.theme.NetflixCloneComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppSection()
                NetflixContentChooser()
                FeaturedMovieSection()
                AddMovieList(movieType = "Watch It Again")
                AddMovieList(movieType = "Drama Movies")
                AddMovieList(movieType = "Action Movies")
                AddMovieList(movieType = "New Release")
            }
        }
    }
    @Composable
//    @Preview
    fun TopAppSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "icon",
                modifier = Modifier.size(60.dp)
            )

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(36.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "profile",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(36.dp)
                )
            }
        }
    }

    @Composable
//    @Preview
    fun NetflixContentChooser() {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 30.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 20.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Categories", color=Color.LightGray, fontSize = 20.sp, )
                Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "drop",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .size(12.dp)

                    )
            }
        }
    }

    @Composable
//    @Preview
    fun FeaturedMovieSection() {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.img_6),
                contentDescription = "Biggest Image" ,
                modifier = Modifier.size(300.dp))


            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Adventure", color = Color.White)
                Text(text = "Thriller", color = Color.White)
                Text(text = "Drama", color = Color.White)
                Text(text = "Indian", color = Color.White)
            }
            
            Row (
                modifier = Modifier
                    .padding(top = 20.dp, start = 80.dp, end = 80.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.img_15),
                        contentDescription = "Add Image" ,
                        modifier = Modifier
                            .background(Color.White)
                            .size(25.dp)
                        )
                    Text(text = "My List", color = Color.LightGray, fontSize = 10.sp)
                }

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(text = "Play", color = Color.Black, fontSize = 18.sp)
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.img_16),
                        contentDescription = "Info Image" ,
                        modifier = Modifier
                            .size(25.dp)
                    )
                    Text(text = "Info", color = Color.LightGray, fontSize = 10.sp)
                }
            }
        }
    }
    
    @Composable
   
    fun AddMovieList(movieType : String) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            Text(text = movieType,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 20.dp, start = 12.dp)
            )
            LazyRow (
                modifier = Modifier.padding(top = 4.dp)
            ){
                itemsIndexed(getRandomMovies()) {index, item ->
                    MovieItemUiModel(imageRes = item.image)
                }
            }
        }
    }


    @Composable
    fun MovieItemUiModel(
        imageRes : Int
    ) {
        Image(painter = painterResource(id = imageRes),
            contentDescription = "First Image",
            modifier = Modifier
                .height(170.dp)
                .width(125.dp)
        )
    }

    fun getRandomMovies() : List<MovieItemModel> {
        val listOfMovies = mutableListOf<MovieItemModel>()
        listOfMovies.add(MovieItemModel(R.drawable.img_3))
        listOfMovies.add(MovieItemModel(R.drawable.img_4))
        listOfMovies.add(MovieItemModel(R.drawable.img_5))
        listOfMovies.add(MovieItemModel(R.drawable.img_6))
        listOfMovies.add(MovieItemModel(R.drawable.img_7))

        listOfMovies.shuffle()

        return listOfMovies
    }
}


data class MovieItemModel(
    val image : Int
)

