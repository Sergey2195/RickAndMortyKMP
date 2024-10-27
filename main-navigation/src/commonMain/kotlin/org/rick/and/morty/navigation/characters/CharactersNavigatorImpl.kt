package org.rick.and.morty.navigation.characters

import org.rick.and.morty.characters.CharactersNavigator
import org.rick.and.morty.navigation.Navigator
import org.rick.and.morty.navigation.episodes.EpisodesDestination
import org.rick.and.morty.navigation.locations.LocationsDestination

class CharactersNavigatorImpl(
    private val navigator: Navigator
): CharactersNavigator {
    override fun navigateToEpisodes() {
        navigator
            .getNavigator()
            .navigate(EpisodesDestination.route)
    }

    override fun navigateToLocations() {
        navigator
            .getNavigator()
            .navigate(LocationsDestination.route)
    }
}
