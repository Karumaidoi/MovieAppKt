package com.bestypie.moviekt.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bestypie.moviekt.model.getMovies
import com.bestypie.moviekt.widgets.MovieRow

@Composable
fun DetailScreen(navController: NavController, movieData: String?) {
    val newMovie = getMovies().filter { movie -> movie.id == movieData }
    Scaffold(modifier = Modifier, topBar = {
        TopAppBar(backgroundColor = Color.Magenta) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back", modifier = Modifier.clickable {
                    navController.popBackStack();
                })

                Spacer(modifier = Modifier.width(20.dp))

                Text(text = newMovie[0].title)
            }
        }
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            MovieRow(movie = newMovie[0], onItemClick = {})

        }
    }

}
