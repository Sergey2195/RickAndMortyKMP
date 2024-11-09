package org.rick.and.morty.characters.internal.data

import androidx.paging.PagingState
import app.cash.paging.PagingSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.rick.and.morty.characters.internal.data.entity.CharactersResponse
import org.rick.and.morty.characters.internal.domain.CharacterModel

internal class CharacterPagingSource : PagingSource<Int, CharacterModel>() {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val currentPage = params.key ?: 1

            val characters = getCharactersWithPage(currentPage)

            LoadResult.Page(
                data = characters,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (characters.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun getCharactersWithPage(page: Int): List<CharacterModel> {
        return httpClient
            .get("https://rickandmortyapi.com/api/character/?page=$page")
            .body<CharactersResponse>()
            .results
            .map {
                CharacterModel(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    gender = it.gender,
                    species = it.species,
                    urlImage = it.image
                )
            }
    }
}