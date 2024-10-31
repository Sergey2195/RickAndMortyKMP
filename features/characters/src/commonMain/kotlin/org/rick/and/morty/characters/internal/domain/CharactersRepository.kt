package org.rick.and.morty.characters.internal.domain

internal interface CharactersRepository {
    fun getCharactersWithPage(page: Int): List<CharacterModel>
}