package org.rick.and.morty.characters.internal.presentation

import androidx.compose.runtime.Immutable
import org.rick.and.morty.characters.internal.domain.CharacterItem

@Immutable
internal data class CharactersState(
    val characters: List<CharacterItem>
)
