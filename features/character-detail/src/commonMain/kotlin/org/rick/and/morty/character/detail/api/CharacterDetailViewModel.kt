package org.rick.and.morty.character.detail.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailModel
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailRepository
import org.rick.and.morty.character.detail.internal.presentation.UiEvent

public class CharacterDetailViewModel internal constructor(
    private val navigator: CharacterDetailNavigator,
    private val repository: CharacterDetailRepository
) : ViewModel() {

    private val _state = MutableStateFlow<CharacterDetailModel?>(null)
    internal val state = _state.asStateFlow()

    internal fun onUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            UiEvent.OnPopBack -> navigator.popBack()
        }
    }

    internal fun onNewArgs(id: String) {
        viewModelScope.launch {
            _state.value = repository.loadCharacterDetails(id)
        }
    }
        /*_state.value = CharacterDetailModel(
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            name = "Morty Smith",
            species = "Human",
            status = "Alive",
            gender = "Male",
            location = Location(
                locationName = "Earth",
                locationId = "20"
            ),
            origin = Location("123", "ABC"),
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
         */
}

public interface CharacterDetailNavigator {
    public fun popBack()
}