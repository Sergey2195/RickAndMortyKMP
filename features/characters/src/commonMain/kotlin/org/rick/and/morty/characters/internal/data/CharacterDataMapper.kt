package org.rick.and.morty.characters.internal.data

import org.rick.and.morty.characters.internal.data.entity.CharacterData
import org.rick.and.morty.characters.internal.domain.CharacterItem

internal fun CharacterData.toDomainModel(): CharacterItem {
    return CharacterItem(
        id = this.id,
        name = this.name,
        urlImage = this.image,
        description = "${this.status} ${this.species} ${this.gender}"
    )
}