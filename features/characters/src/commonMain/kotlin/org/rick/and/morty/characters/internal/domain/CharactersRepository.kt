package org.rick.and.morty.characters.internal.domain

internal interface CharactersRepository {
    suspend fun getFirstPage(): List<CharacterModel>
    suspend fun getNewPage(): List<CharacterModel>
}