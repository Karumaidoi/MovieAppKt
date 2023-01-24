package com.bestypie.moviekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bestypie.moviekt.navigation.MovieNavigation
import com.bestypie.moviekt.ui.theme.MovieKtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieKtTheme {
       content();
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
       MovieNavigation()
    }
}