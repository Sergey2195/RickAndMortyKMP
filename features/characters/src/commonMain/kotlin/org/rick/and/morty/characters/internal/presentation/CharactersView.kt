package org.rick.and.morty.characters.internal.presentation

import Design
import MainBottomNavigation
import Tab
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.rick.and.morty.characters.internal.domain.CharacterItem

@Composable
internal fun CharactersView(
    state: CharactersState,
    onUiEvent: (UiEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            MainBottomNavigation(
                selectedTab = Tab.CHARACTERS,
                onClickIndex = { onUiEvent.invoke(UiEvent.TabClick(it)) }
            )
        }
    ) {
        CharactersItemView(
            paddingValues = it,
            characters = state.characters,
            onUiEvent = onUiEvent
        )
    }
}

@Composable
private fun CharactersItemView(
    paddingValues: PaddingValues,
    characters: List<CharacterItem>,
    onUiEvent: (UiEvent) -> Unit
) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        contentPadding = paddingValues,
        state = lazyListState,
        modifier = Modifier.background(Design.Colors.backgroundPrimary)
    ) {
        item { Spacer(Modifier.statusBarsPadding().heightIn(1.dp)) }

        items(
            items = characters,
            key = { it.id }
        ) {
            CharacterCell(
                character = it,
                onUiState = onUiEvent
            )
        }
    }

    LaunchedEffect(lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index) {
        onUiEvent.invoke(
            UiEvent.OnChangedLastVisibleItem(
                index = lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            )
        )
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
