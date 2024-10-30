package org.rick.and.morty.characters.internal.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class CharactersState(
    val characters: List<CharacterItem>
)

@Immutable
data class CharacterItem(
    val id: String,
    val name: String,
    val description: String,
    val urlImage: String
)
