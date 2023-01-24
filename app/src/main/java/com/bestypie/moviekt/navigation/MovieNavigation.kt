package com.bestypie.moviekt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bestypie.moviekt.screens.home.HomeScreen
import com.bestypie.moviekt.screens.details.DetailScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreen.HomeScreen.name) {
        composable(MovieScreen.HomeScreen.name) {
            // Here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        // Passing with Arguments
        composable(MovieScreen.DetailScreen.name+"/{movie}", arguments = listOf(navArgument(name = "movie") {
            type = NavType.StringType
        })) {
            DetailScreen(navController = navController, it.arguments?.getString("movie"));
        }
    }
}


