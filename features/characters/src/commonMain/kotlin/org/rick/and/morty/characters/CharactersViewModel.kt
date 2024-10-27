package org.rick.and.morty.characters

import Tabs
import androidx.lifecycle.ViewModel

class CharactersViewModel(
    private val navigator: CharactersNavigator
) : ViewModel() {

    fun onClickBottomNavigation(clicked: Tabs) {
        when (clicked) {
            Tabs.EPISODES -> navigateToEpisodes()
            Tabs.LOCATIONS -> navigateToLocations()
            else -> {}
        }
    }

    private fun navigateToEpisodes() {
        navigator.navigateToEpisodes()
    }

    private fun navigateToLocations() {
        navigator.navigateToLocations()
    }
}

interface CharactersNavigator {
    fun navigateToEpisodes()
    fun navigateToLocations()
}