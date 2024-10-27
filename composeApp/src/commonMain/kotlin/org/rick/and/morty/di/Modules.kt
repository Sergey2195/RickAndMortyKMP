package org.rick.and.morty.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rick.and.morty.characters.CharactersNavigator
import org.rick.and.morty.characters.CharactersViewModel
import org.rick.and.morty.navigation.Navigator
import org.rick.and.morty.navigation.characters.CharactersNavigatorImpl

val navigatorModule = module {
    single { Navigator() }
}
val charactersModule = module {
    singleOf(::CharactersNavigatorImpl).bind<CharactersNavigator>()

    viewModel {
        CharactersViewModel(get())
    }
}