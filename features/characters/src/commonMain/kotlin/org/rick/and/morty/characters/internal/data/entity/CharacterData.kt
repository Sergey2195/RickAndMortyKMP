package org.rick.and.morty.characters.internal.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharactersResponse(
    @SerialName("info")
    val info: PageInfo,
    @SerialName("results")
    val results: List<CharacterData>
)

@Serializable
internal data class CharacterData(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("status")
    val status: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("species")
    val species: String,
    @SerialName("image")
    val image: String
)

@Serializable
internal data class PageInfo(
    @SerialName("pages")
    val pages: Int
)