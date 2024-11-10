package org.rick.and.morty.characters.api

import Tab
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.map
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import org.rick.and.morty.characters.internal.presentation.CharacterItem
import org.rick.and.morty.characters.internal.presentation.CharactersState
import org.rick.and.morty.characters.internal.presentation.UiEvent
import org.rick.and.morty.characters.internal.presentation.toCharacterItem

public class CharactersViewModel internal constructor(
    private val navigator: CharactersNavigator,
    private val repository: CharactersRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState(PagingData.empty()))
    internal val state: StateFlow<CharactersState>
        get() = _state.asStateFlow()

    init {
        repository
            .getCharactersFlow()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .onEach { pagingData ->
                _state.value = CharactersState(pagingData.map { it.toCharacterItem() })
            }
            .launchIn(viewModelScope)
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