package org.rick.and.morty.characters.internal.domain

internal interface CharactersRepository {
    suspend fun getFirstPage(): List<CharacterItem>
    suspend fun getNewPage(): List<CharacterItem>
}