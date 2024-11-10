package org.rick.and.morty.characters.internal.data

import org.rick.and.morty.characters.internal.data.entity.CharacterData
import org.rick.and.morty.characters.internal.domain.CharacterModel

internal fun CharacterData.toDomainModel(): CharacterModel {
    return CharacterModel(
        id = this.id,
        name = this.name,
        status = this.status,
        gender = this.gender,
        species = this.species,
        urlImage = this.image
    )
}