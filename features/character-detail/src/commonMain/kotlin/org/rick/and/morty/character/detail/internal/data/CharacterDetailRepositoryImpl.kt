package org.rick.and.morty.character.detail.internal.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailModel
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailRepository
import org.rick.and.morty.character.detail.internal.domain.Episode
import org.rick.and.morty.character.detail.internal.domain.Location

internal class CharacterDetailRepositoryImpl : CharacterDetailRepository {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun loadCharacterDetails(id: String): CharacterDetailModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = httpClient
                    .get("https://rickandmortyapi.com/api/character/$id")
                    .body<CharacterDetailResponse>()

                getCharacterDetailModel(response)
            } catch (e: Exception) {
                println(e.toString())
                null
            }
        }
    }

    private suspend fun getCharacterDetailModel(response: CharacterDetailResponse): CharacterDetailModel {
        val episodeIds = extractEpisodeIds(response.episodeUrls)
        val episodes = fetchEpisodes(episodeIds)

        return CharacterDetailModel(
            image = response.image,
            name = response.name,
            species = response.species,
            status = response.status,
            gender = response.gender,
            location = mapLocation(response.location),
            origin = mapLocation(response.origin),
            episodes = episodes.map { mapEpisode(it) }
        )
    }

    private fun extractEpisodeIds(episodeUrls: List<String>): String =
        episodeUrls.joinToString(",") { it.substringAfterLast("/") }

    private suspend fun fetchEpisodes(episodeIds: String): List<EpisodeDetails> =
        if (episodeIds.contains(",")) {
            httpClient.get("https://rickandmortyapi.com/api/episode/$episodeIds").body()
        } else {
            listOf(httpClient.get("https://rickandmortyapi.com/api/episode/$episodeIds").body())
        }

    private fun mapLocation(locationResponse: org.rick.and.morty.character.detail.internal.data.Location): Location =
        Location(
            locationId = locationResponse.url.substringAfterLast("/"),
            locationName = locationResponse.locationName
        )

    private fun mapEpisode(episodeDetails: EpisodeDetails): Episode =
        Episode(
            episodeId = episodeDetails.id,
            episodeName = episodeDetails.name,
            episodeCount = episodeDetails.episode
        )
}
