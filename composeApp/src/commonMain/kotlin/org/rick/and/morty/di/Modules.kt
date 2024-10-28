package org.rick.and.morty.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rick.and.morty.characters.CharactersNavigator
import org.rick.and.morty.characters.CharactersViewModel
import org.rick.and.morty.episodes.EpisodesNavigator
import org.rick.and.morty.episodes.EpisodesViewModel
import org.rick.and.morty.locations.LocationsNavigator
import org.rick.and.morty.locations.LocationsViewModel
import org.rick.and.morty.navigation.characters.CharactersNavigatorImpl
import org.rick.and.morty.navigation.episodes.EpisodesNavigatorImpl
import org.rick.and.morty.navigation.locations.LocationsNavigatorImpl

val charactersModule = module {
    singleOf(::CharactersNavigatorImpl).bind<CharactersNavigator>()
    viewModelOf(::CharactersViewModel)
}

val episodesModule = module {
    singleOf(::EpisodesNavigatorImpl).bind<EpisodesNavigator>()
    viewModelOf(::EpisodesViewModel)
}

val locationsModule = module {
    singleOf(::LocationsNavigatorImpl).bind<LocationsNavigator>()
    viewModelOf(::LocationsViewModel)
}