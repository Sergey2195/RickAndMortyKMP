package org.rick.and.morty.character.detail.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import org.rick.and.morty.character.detail.internal.presentation.CharacterDetailView

@Composable
public fun CharacterDetailScreen(
    id: String,
    viewModel: CharacterDetailViewModel
) {
    val state = viewModel.state.collectAsState().value

    state?.let {
        CharacterDetailView(it)
    }

    LaunchedEffect(Unit) {
        viewModel.onNewArgs(id)
    }
}