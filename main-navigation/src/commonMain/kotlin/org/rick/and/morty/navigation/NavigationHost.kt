package org.rick.and.morty.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.rick.and.morty.navigation.characters.CharactersDestination
import org.rick.and.morty.navigation.episodes.EpisodesDestination
import org.rick.and.morty.navigation.locations.LocationsDestination

@Composable
fun NavigationHost() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = CharactersDestination.route
    ) {
        composable(CharactersDestination.route) {
            Text(CharactersDestination.route)
        }

        composable(EpisodesDestination.route) {
            Text(EpisodesDestination.route)
        }

        composable(LocationsDestination.route) {
            Text(LocationsDestination.route)
        }
    }
}