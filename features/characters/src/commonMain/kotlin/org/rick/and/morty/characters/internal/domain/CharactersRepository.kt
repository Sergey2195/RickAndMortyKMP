package org.rick.and.morty.characters.internal.domain

internal interface CharactersRepository {
    suspend fun getCharactersWithPage(page: Int): List<CharacterModel>
}