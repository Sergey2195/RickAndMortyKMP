package org.rick.and.morty.character.detail.internal.domain

import androidx.compose.runtime.Immutable

@Immutable
internal data class CharacterDetailState(
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val location: Location,
    val episodes: List<Episode>
)

@Immutable
internal data class Episode(
    val episodeId: String,
    val episodeName: String,
    val episodeCount: String,
)

@Immutable
internal data class Location(
    val locationId: String,
    val locationName: String
)
