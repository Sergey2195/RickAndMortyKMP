package org.rick.and.morty.locations

import Tab
import androidx.lifecycle.ViewModel

class LocationsViewModel(
    private val navigator: LocationsNavigator
): ViewModel() {
    fun onClickBottomNavigation(clicked: Tab) {
        when (clicked) {
            Tab.CHARACTERS -> navigateToCharacters()
            Tab.EPISODES -> navigateToEpisodes()
            else -> {}
        }
    }

    private fun navigateToCharacters() {
        navigator.navigateToCharacters()
    }

    private fun navigateToEpisodes() {
        navigator.navigateToEpisodes()
    }
}

interface LocationsNavigator {
    fun navigateToCharacters()
    fun navigateToEpisodes()
}