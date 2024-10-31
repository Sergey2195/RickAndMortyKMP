package org.rick.and.morty.characters.api

import Tab
import androidx.lifecycle.ViewModel
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import org.rick.and.morty.characters.internal.presentation.UiEvent

class CharactersViewModel internal constructor(
    private val navigator: CharactersNavigator,
    private val repository: CharactersRepository,
) : ViewModel() {

    internal fun onUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is UiEvent.TabClick -> onClickBottomNavigation(uiEvent.tab)
            is UiEvent.ItemClick -> {}
        }
    }

    private fun onClickBottomNavigation(clicked: Tab) {
        when (clicked) {
            Tab.EPISODES -> navigateToEpisodes()
            Tab.LOCATIONS -> navigateToLocations()
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