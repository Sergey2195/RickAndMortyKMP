package org.rick.and.morty.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import org.rick.and.morty.characters.api.CharactersScreen
import org.rick.and.morty.episodes.EpisodesScreen
import org.rick.and.morty.locations.LocationsScreen
import org.rick.and.morty.navigation.characters.CharactersDestination
import org.rick.and.morty.navigation.episodes.EpisodesDestination
import org.rick.and.morty.navigation.locations.LocationsDestination

val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>) -> EnterTransition =
    { fadeIn(initialAlpha = 0.9f, animationSpec = tween(100)) }
val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>) -> ExitTransition =
    { fadeOut(targetAlpha = 0.9f, animationSpec = tween(100)) }

inline fun NavGraphBuilder.screen(
    route: String,
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        content = content,
        enterTransition = enterTransition,
        exitTransition = exitTransition
    )
}

@Composable
fun MainNavigationNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CharactersDestination.route,
    ) {
        screen(CharactersDestination.route) {
            CharactersScreen(koinViewModel())
        }

        screen(EpisodesDestination.route) {
            EpisodesScreen(koinViewModel())
        }

        screen(LocationsDestination.route) {
            LocationsScreen(koinViewModel())
        }
    }
}