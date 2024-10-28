package org.rick.and.morty.episodes

import Tabs
import androidx.lifecycle.ViewModel

class EpisodesViewModel(
    private val navigator: EpisodesNavigator
): ViewModel() {
    fun onClickBottomNavigation(clicked: Tabs) {
        when (clicked) {
            Tabs.CHARACTERS -> navigateToCharacters()
            Tabs.LOCATIONS -> navigateToLocations()
            else -> {}
        }
    }

    private fun navigateToCharacters() {
        navigator.navigateToCharacters()
    }

    private fun navigateToLocations() {
        navigator.navigateToLocations()
    }
}

interface EpisodesNavigator {
    fun navigateToCharacters()
    fun navigateToLocations()
}