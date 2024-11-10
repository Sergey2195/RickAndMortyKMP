package org.rick.and.morty.navigation.episodes

import org.rick.and.morty.episodes.EpisodesNavigator
import org.rick.and.morty.navigation.Navigator
import org.rick.and.morty.navigation.characters.CharactersDestination
import org.rick.and.morty.navigation.locations.LocationsDestination

class EpisodesNavigatorImpl: EpisodesNavigator {
    override fun navigateToCharacters() {
        Navigator
            .navigateWithSingleInstance(CharactersDestination.route)
    }

    override fun navigateToLocations() {
        Navigator
            .navigateWithSingleInstance(LocationsDestination.route)
    }
}