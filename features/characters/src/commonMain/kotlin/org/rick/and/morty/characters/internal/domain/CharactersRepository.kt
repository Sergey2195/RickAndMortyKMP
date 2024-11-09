package org.rick.and.morty.characters.internal.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow

internal interface CharactersRepository {
    fun getClearCharactersFlow(): Flow<PagingData<CharacterModel>>
}