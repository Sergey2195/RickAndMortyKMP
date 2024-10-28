package org.rick.and.morty.navigation.characters

import androidx.navigation.NavOptions
import org.rick.and.morty.characters.CharactersNavigator
import org.rick.and.morty.navigation.Navigator
import org.rick.and.morty.navigation.episodes.EpisodesDestination
import org.rick.and.morty.navigation.locations.LocationsDestination

class CharactersNavigatorImpl: CharactersNavigator {
    override fun navigateToEpisodes() {
        Navigator
            .getNavigator()
            .navigate(EpisodesDestination.route)
    }

    override fun navigateToLocations() {
        Navigator
            .getNavigator()
            .navigate(LocationsDestination.route)
    }
}
