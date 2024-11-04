package org.rick.and.morty.characters.api

import Tab
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import org.rick.and.morty.characters.internal.presentation.CharacterItem
import org.rick.and.morty.characters.internal.presentation.CharactersState
import org.rick.and.morty.characters.internal.presentation.UiEvent

public class CharactersViewModel internal constructor(
    private val navigator: CharactersNavigator,
    private val repository: CharactersRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState(emptyList()))
    internal val state: StateFlow<CharactersState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = CharactersState(repository
                .getCharactersWithPage(0)
                .map {
                    CharacterItem(
                        id = it.id,
                        name = it.name,
                        description = "${it.status} ${it.gender} ${it.species}",
                        urlImage = it.urlImage
                    )
                })
        }
    }

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