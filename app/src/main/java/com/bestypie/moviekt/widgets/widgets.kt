package com.bestypie.moviekt.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.bestypie.moviekt.model.Movie

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit) {
    val isExpanded = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .clickable {
            onItemClick(movie.id)
        }
        .padding(4.dp)
        .fillMaxWidth()
        , elevation = 6.dp, shape = RoundedCornerShape(corner = CornerSize(16.dp)), ) {
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp), shape = RectangleShape, elevation = 4.dp) {
                Image(painter = rememberImagePainter(data = movie.images[0], builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }), contentDescription = "Movie Data")
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Year ${movie.year}", style = MaterialTheme.typography.caption)
                
                AnimatedVisibility(visible = isExpanded.value) {
                    Column {
                        Text(text = "Plot: ${movie.plot}", modifier = Modifier.padding(vertical = 10.dp))

                        Divider()

                        Text(text = "Director: ${movie.director}")
                        Text(text = "Actors: ${movie.director}")
                        Text(text = "Rating: ${movie.rating}")
                    }
                }

            }

            Icon(imageVector = if(!isExpanded.value) Icons.Filled.ArrowDropDown else Icons.Filled.KeyboardArrowUp, contentDescription = "Arrow DropDown", modifier = Modifier
                .size(25.dp)
                .clickable {
                    isExpanded.value = !isExpanded.value;
                })
           
        }
    }
}


