package org.rick.and.morty.characters.internal.data

import org.rick.and.morty.characters.internal.domain.CharacterModel
import org.rick.and.morty.characters.internal.domain.CharactersRepository
import kotlin.random.Random

internal class CharactersRepositoryImpl: CharactersRepository {
    override fun getCharactersWithPage(page: Int): List<CharacterModel> {
        val hardcodedList = listOf(
            CharacterModel(
                id = "1",
                name = "Rick Sanchez",
                status = "Alive",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            CharacterModel(
                id = "2",
                name = "Morty Smith",
                status = "Alive",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            ),
            CharacterModel(
                id = "3",
                name = "Summer Smith",
                status = "Alive",
                gender = "Female",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
            ),
            CharacterModel(
                id = "4",
                name = "Beth Smith",
                status = "Alive",
                gender = "Female",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/4.jpeg"
            ),
            CharacterModel(
                id = "5",
                name = "Jerry Smith",
                status = "Alive",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/5.jpeg"
            ),
            CharacterModel(
                id = "6",
                name = "Abadango Cluster Princess",
                status = "Alive",
                gender = "Female",
                species = "Alien",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/6.jpeg"
            ),
            CharacterModel(
                id = "7",
                name = "Abradolf Lincler",
                status = "unknown",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/7.jpeg"
            ),
            CharacterModel(
                id = "8",
                name = "Adjudicator Rick",
                status = "Dead",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/8.jpeg"
            ),
            CharacterModel(
                id = "9",
                name = "Agency Director",
                status = "Dead",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/9.jpeg"
            ),
            CharacterModel(
                id = "10",
                name = "Alan Rails",
                status = "Dead",
                gender = "Male",
                species = "Human",
                urlImage = "https://rickandmortyapi.com/api/character/avatar/10.jpeg"
            )
        )

        return hardcodedList + hardcodedList.map { it.copy(id = Random.nextInt().toString()) }
    }
}