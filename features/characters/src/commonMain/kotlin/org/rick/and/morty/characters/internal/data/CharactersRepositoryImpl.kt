package org.rick.and.morty.characters.internal.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.rick.and.morty.characters.internal.data.entity.CharactersResponse
import org.rick.and.morty.characters.internal.domain.CharacterItem
import org.rick.and.morty.characters.internal.domain.CharactersRepository

internal class CharactersRepositoryImpl : CharactersRepository {
    private var totalPages = Int.MAX_VALUE
    private var currentPage = 1
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getFirstPage(): List<CharacterItem> {
        val characterResponse = getCharactersWithPage(1)

        totalPages = characterResponse?.info?.pages ?: Int.MAX_VALUE

        return characterResponse
            ?.results
            ?.map { it.toDomainModel() }
            ?: emptyList()
    }

    override suspend fun getNewPage(): List<CharacterItem> {
        currentPage++

        return if (totalPages >= currentPage) {
            getCharactersWithPage(currentPage)
                ?.results
                ?.map { it.toDomainModel() }
                ?: emptyList()
        } else {
            emptyList()
        }
    }

    private suspend fun getCharactersWithPage(page: Int): CharactersResponse? {
        return try {
            httpClient
                .get("https://rickandmortyapi.com/api/character/?page=$page")
                .body<CharactersResponse>()
        } catch (e: Exception) {
            println(e.toString())
            null
        }
    }
}