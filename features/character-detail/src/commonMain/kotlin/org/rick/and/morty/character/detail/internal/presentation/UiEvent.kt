package org.rick.and.morty.character.detail.internal.presentation

internal sealed class UiEvent {
    data object OnPopBack : UiEvent()
}