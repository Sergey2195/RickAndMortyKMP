package org.rick.and.morty.locations

import Tabs
import androidx.lifecycle.ViewModel

class LocationsViewModel(
    private val navigator: LocationsNavigator
): ViewModel() {
    fun onClickBottomNavigation(clicked: Tabs) {
        when (clicked) {
            Tabs.CHARACTERS -> navigateToCharacters()
            Tabs.EPISODES -> navigateToEpisodes()
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