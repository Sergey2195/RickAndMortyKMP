package org.rick.and.morty.characters.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.rick.and.morty.characters.internal.presentation.CharactersView

@Composable
public fun CharactersScreen(charactersViewModel: CharactersViewModel) {
    CharactersView(
        state = charactersViewModel.state.collectAsState().value,
        onUiState = charactersViewModel::onUiEvent
    )
}
