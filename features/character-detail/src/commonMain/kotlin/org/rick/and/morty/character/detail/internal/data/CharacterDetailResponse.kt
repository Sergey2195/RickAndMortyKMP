package org.rick.and.morty.character.detail.internal.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharacterDetailResponse(
    @SerialName("name")
    val name: String,
    @SerialName("species")
    val species: String,
    @SerialName("status")
    val status: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("origin")
    val origin: Location,
    @SerialName("location")
    val location: Location,
    @SerialName("image")
    val image: String,
    @SerialName("episode")
    val episodeUrls: List<String>
)

@Serializable
internal data class Location(
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val locationName: String
)

@Serializable
internal data class EpisodeDetails(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("episode")
    val episode: String
)
