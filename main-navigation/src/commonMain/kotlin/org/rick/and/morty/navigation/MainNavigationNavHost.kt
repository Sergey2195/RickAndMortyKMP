package org.rick.and.morty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.rick.and.morty.characters.CharactersScreen
import org.rick.and.morty.episodes.EpisodesScreen
import org.rick.and.morty.locations.LocationsScreen
import org.rick.and.morty.navigation.characters.CharactersDestination
import org.rick.and.morty.navigation.episodes.EpisodesDestination
import org.rick.and.morty.navigation.locations.LocationsDestination

@Composable
fun MainNavigationNavHost() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = CharactersDestination.route
    ) {
        composable(CharactersDestination.route) {
            CharactersScreen()
        }

        composable(EpisodesDestination.route) {
            EpisodesScreen()
        }

        composable(LocationsDestination.route) {
            LocationsScreen()
        }
    }
}