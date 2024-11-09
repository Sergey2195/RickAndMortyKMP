package org.rick.and.morty.characters.api

import Tab
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import app.cash.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import org.rick.and.morty.characters.internal.presentation.CharacterItem
import org.rick.and.morty.characters.internal.presentation.UiEvent
import org.rick.and.morty.characters.internal.presentation.toCharacterItem

public class CharactersViewModel internal constructor(
    private val navigator: CharactersNavigator,
    private val repository: CharactersRepository,
) : ViewModel() {

    private val _state: Flow<PagingData<CharacterItem>> = repository
        .getClearCharactersFlow()
        .map {
            it.map { model -> model.toCharacterItem() }
        }
    internal val state get() = _state


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

public interface CharactersNavigator {
    public fun navigateToEpisodes()
    public fun navigateToLocations()
}