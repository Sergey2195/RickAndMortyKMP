package org.rick.and.morty.characters.internal.presentation

import androidx.compose.runtime.Immutable
import app.cash.paging.compose.LazyPagingItems


@Immutable
internal data class CharactersState(
    val characters: LazyPagingItems<CharacterItem>
)

@Immutable
internal data class CharacterItem(
    val id: String,
    val name: String,
    val description: String,
    val urlImage: String
)
