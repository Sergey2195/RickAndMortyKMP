package org.rick.and.morty.characters.internal.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.rick.and.morty.characters.internal.data.entity.CharactersResponse
import org.rick.and.morty.characters.internal.domain.CharacterModel
import org.rick.and.morty.characters.internal.domain.CharactersRepository

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
}