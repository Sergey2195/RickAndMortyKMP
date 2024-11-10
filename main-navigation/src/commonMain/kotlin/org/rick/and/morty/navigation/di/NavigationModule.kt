package org.rick.and.morty.navigation.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rick.and.morty.character.detail.api.CharacterDetailNavigator
import org.rick.and.morty.characters.api.CharactersNavigator
import org.rick.and.morty.episodes.EpisodesNavigator
import org.rick.and.morty.locations.LocationsNavigator
import org.rick.and.morty.navigation.characterDetail.CharacterDetailNavigatorImpl
import org.rick.and.morty.navigation.characters.CharactersNavigatorImpl
import org.rick.and.morty.navigation.episodes.EpisodesNavigatorImpl
import org.rick.and.morty.navigation.locations.LocationsNavigatorImpl

val navigationModule = module {
    singleOf(::CharactersNavigatorImpl).bind<CharactersNavigator>()
    singleOf(::EpisodesNavigatorImpl).bind<EpisodesNavigator>()
    singleOf(::LocationsNavigatorImpl).bind<LocationsNavigator>()
    singleOf(::CharacterDetailNavigatorImpl).bind<CharacterDetailNavigator>()
}