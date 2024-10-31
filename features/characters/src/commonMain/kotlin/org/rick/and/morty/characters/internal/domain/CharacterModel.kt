package org.rick.and.morty.characters.internal.domain

internal data class CharacterModel(
    val id: String,
    val name: String,
    val status: String,
    val gender: String,
    val species: String,
    val urlImage: String
)