package org.rick.and.morty.character.detail.internal.domain

internal interface CharacterDetailRepository {
    suspend fun loadCharacterDetails(id: String) : CharacterDetailModel?
}