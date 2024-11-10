package org.rick.and.morty.characters.api

import Tab
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import org.rick.and.morty.characters.internal.presentation.CharactersState
import org.rick.and.morty.characters.internal.presentation.UiEvent

public class CharactersViewModel internal constructor(
    private val navigator: CharactersNavigator,
    private val repository: CharactersRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState(emptyList()))
    internal val state: StateFlow<CharactersState>
        get() = _state.asStateFlow()
    private var isRequestSent = false

    init {
        viewModelScope.launch {
            _state.value = CharactersState(
                repository
                    .getFirstPage()
            )
        }
    }

    internal fun onUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is UiEvent.TabClick -> onClickBottomNavigation(uiEvent.tab)
            is UiEvent.OnChangedLastVisibleItem -> onChangedLastVisibleItem(uiEvent.index)
            is UiEvent.ItemClick -> navigator.navigateToCharacterDetail(uiEvent.id)
        }
    }

    private fun onClickBottomNavigation(clicked: Tab) {
        when (clicked) {
            Tab.EPISODES -> navigateToEpisodes()
            Tab.LOCATIONS -> navigateToLocations()
            else -> {}
        }
    }

    private fun onChangedLastVisibleItem(index: Int) {
        if (_state.value.characters.isEmpty()) return

        val isNeedLoadNewPage = _state.value.characters.lastIndex - index <= 10
        if (isNeedLoadNewPage && !isRequestSent) {
            isRequestSent = true

            viewModelScope.launch {
                loadNewPage()
            }
        }
    }

    private suspend fun loadNewPage() {
        val newCharacters = repository.getNewPage()
        isRequestSent = false

        _state.update {
            CharactersState(it.characters + newCharacters)
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
    public fun navigateToCharacterDetail(id: String)
}