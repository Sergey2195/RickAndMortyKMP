package org.rick.and.morty.characters.internal.data

import androidx.paging.PagingConfig
import app.cash.paging.Pager
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.rick.and.morty.characters.internal.domain.CharacterModel
import org.rick.and.morty.characters.internal.domain.CharactersRepository

internal class CharactersRepositoryImpl : CharactersRepository {
    override fun getClearCharactersFlow(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(20, prefetchDistance = 1),
            pagingSourceFactory = {
                CharacterPagingSource()
            }
        ).flow
    }
}