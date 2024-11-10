package org.rick.and.morty.characters.internal.data

import app.cash.paging.PagingData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.serialization.json.Json
import org.rick.and.morty.characters.internal.data.entity.CharactersResponse
import org.rick.and.morty.characters.internal.domain.CharacterModel
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import kotlin.random.Random

internal class CharactersRepositoryImpl : CharactersRepository {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getCharactersWithPage(page: Int): List<CharacterModel> {
        return httpClient
            .get("https://rickandmortyapi.com/api/character")
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

    override fun getCharactersFlow(): Flow<PagingData<CharacterModel>> {
        return emptyFlow()
    }
}