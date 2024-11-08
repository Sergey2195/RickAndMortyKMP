package org.rick.and.morty.characters.internal.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow

internal interface CharactersRepository {
    suspend fun getCharactersWithPage(page: Int): List<CharacterModel>

    fun getCharactersFlow(): Flow<PagingData<CharacterModel>>
}