package org.rick.and.morty.episodes

import Tab
import androidx.lifecycle.ViewModel

class EpisodesViewModel(
    private val navigator: EpisodesNavigator
): ViewModel() {
    fun onClickBottomNavigation(clicked: Tab) {
        when (clicked) {
            Tab.CHARACTERS -> navigateToCharacters()
            Tab.LOCATIONS -> navigateToLocations()
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