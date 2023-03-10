package com.bestypie.moviekt.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bestypie.moviekt.model.Movie
import com.bestypie.moviekt.model.getMovies
import com.bestypie.moviekt.navigation.MovieScreen
import com.bestypie.moviekt.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(modifier = Modifier, topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text("Movies")
        }
    }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController,movieList: List<Movie> = getMovies()) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items ( items = movieList ) { movie ->
                MovieRow(movie = movie) {
                    navController.navigate(route = MovieScreen.DetailScreen.name+"/${it}")
                }
            }
        }
    }
}

