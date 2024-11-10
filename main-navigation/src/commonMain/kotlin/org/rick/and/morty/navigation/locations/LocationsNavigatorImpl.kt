package org.rick.and.morty.navigation.locations

import org.rick.and.morty.locations.LocationsNavigator
import org.rick.and.morty.navigation.Navigator
import org.rick.and.morty.navigation.characters.CharactersDestination
import org.rick.and.morty.navigation.episodes.EpisodesDestination

class LocationsNavigatorImpl: LocationsNavigator {
    override fun navigateToCharacters() {
        Navigator
            .navigateWithSingleInstance(CharactersDestination.route)
    }

    override fun navigateToEpisodes() {
        Navigator
            .navigateWithSingleInstance(EpisodesDestination.route)
    }
}