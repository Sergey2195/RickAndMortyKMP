package org.rick.and.morty.character.detail.api

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
public fun CharacterDetailScreen(
    id: String,
    viewModel: CharacterDetailViewModel
) {
    Text("CharacterDetailScreen $id")

    LaunchedEffect(Unit) {
        viewModel.onNewArgs(id)
    }
}