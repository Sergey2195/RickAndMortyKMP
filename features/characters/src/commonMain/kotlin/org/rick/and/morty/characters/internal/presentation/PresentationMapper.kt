package org.rick.and.morty.characters.internal.presentation

import org.rick.and.morty.characters.internal.domain.CharacterModel

internal fun CharacterModel.toCharacterItem(): CharacterItem {
    return CharacterItem(
        id = this.id,
        name = this.name,
        description = "${this.status} ${this.gender} ${this.species}",
        urlImage = this.urlImage
    )
}