package org.rick.and.morty.characters.api

import androidx.compose.runtime.Composable
import org.rick.and.morty.characters.internal.presentation.CharacterItem
import org.rick.and.morty.characters.internal.presentation.CharactersState
import org.rick.and.morty.characters.internal.presentation.CharactersView
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Composable
fun CharactersScreen(charactersViewModel: CharactersViewModel) {
    CharactersView(
        state = testState,
        onUiState = charactersViewModel::onUiEvent
    )
}

@OptIn(ExperimentalUuidApi::class)
val testState = CharactersState(
    List(30) {
        CharacterItem(
            id = Uuid.random().toString(),
            name = "Rick Sanchez",
            description = "Alive, Male, Human",
            urlImage = "https://rickandmortyapi.com/api/character/avatar/77.jpeg"
        )
    }
)