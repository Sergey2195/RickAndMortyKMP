package org.rick.and.morty.character.detail.api

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailState
import org.rick.and.morty.character.detail.internal.domain.Episode
import org.rick.and.morty.character.detail.internal.domain.Location

public class CharacterDetailViewModel internal constructor(

) : ViewModel() {

    private val _state = MutableStateFlow<CharacterDetailState?>(null)
    internal val state = _state.asStateFlow()

    internal fun onNewArgs(id: String) {
        _state.value = CharacterDetailState(
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            name = "Morty Smith",
            species = "Human",
            status = "Alive",
            gender = "Male",
            location = Location(
                locationName = "Earth",
                locationId = "20"
            ),
            episodes = listOf(
                Episode(
                    episodeId = "1",
                    episodeName = "Pilot",
                    episodeCount = "S01E01"
                ),
                Episode(
                    episodeId = "2",
                    episodeName = "Lawnmower Dog",
                    episodeCount = "S01E02"
                ),
                Episode(
                    episodeId = "3",
                    episodeName = "Lawnmower Dog123",
                    episodeCount = "S01E03"
                ),
                Episode(
                    episodeId = "4",
                    episodeName = "Lawnmower Dog112",
                    episodeCount = "S01E04"
                ),
            )
        )
    }

}