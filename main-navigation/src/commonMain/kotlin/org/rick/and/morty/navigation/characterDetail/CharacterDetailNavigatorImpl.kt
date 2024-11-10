package org.rick.and.morty.navigation.characterDetail

import org.rick.and.morty.character.detail.api.CharacterDetailNavigator
import org.rick.and.morty.navigation.Navigator

class CharacterDetailNavigatorImpl: CharacterDetailNavigator {
    override fun popBack() {
        Navigator
            .getNavigator()
            .popBackStack()
    }
}