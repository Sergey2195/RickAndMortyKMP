package org.rick.and.morty.characters.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import app.cash.paging.compose.collectAsLazyPagingItems
import org.rick.and.morty.characters.internal.presentation.CharactersView

@Composable
public fun CharactersScreen(charactersViewModel: CharactersViewModel) {

    val characters = charactersViewModel.state.collectAsLazyPagingItems()

    CharactersView(
        characters = characters,
        onUiState = charactersViewModel::onUiEvent
    )
}
