package org.rick.and.morty.characters.internal.presentation

import Tab

internal sealed class UiEvent {
    data class TabClick(val tab: Tab): UiEvent()
    data class ItemClick(val id: String): UiEvent()
}