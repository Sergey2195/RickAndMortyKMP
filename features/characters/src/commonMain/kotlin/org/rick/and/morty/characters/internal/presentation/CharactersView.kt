package org.rick.and.morty.characters.internal.presentation

import Design
import MainBottomNavigation
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
internal fun CharactersView(
    state: CharactersState,
    onUiState: (UiEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            MainBottomNavigation(
                selectedTab = Tab.CHARACTERS,
                onClickIndex = { onUiState.invoke(UiEvent.TabClick(it)) }
            )
        }
    ) {
        Column {
            CharactersItemView(
                modifier = Modifier.weight(1f),
                characters = state.characters,
                onUiState = onUiState
            )
        }
    }
}

@Composable
private fun CharactersItemView(
    modifier: Modifier,
    characters: List<CharacterItem>,
    onUiState: (UiEvent) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = characters,
            key = { it.id }
        ) {
            CharacterCell(
                character = it,
                onUiState = onUiState
            )
        }
    }
}

@Composable
private fun CharacterCell(
    character: CharacterItem,
    onUiState: (UiEvent) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onUiState(UiEvent.ItemClick(character.id)) }
            .padding(horizontal = 20.dp, vertical = 4.dp)
    ) {
        AsyncImage(
            model = character.urlImage,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.padding(start = 18.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = character.name,
                color = Design.Colors.textPrimary,
                fontSize = 16.sp
            )

            Text(
                text = character.description,
                color = Design.Colors.textSecondary,
                fontSize = 14.sp
            )
        }
    }
}
