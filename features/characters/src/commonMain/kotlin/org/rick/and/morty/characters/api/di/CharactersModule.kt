package org.rick.and.morty.characters.api.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rick.and.morty.characters.api.CharactersViewModel
import org.rick.and.morty.characters.internal.data.CharactersRepositoryImpl
import org.rick.and.morty.characters.internal.domain.CharactersRepository

val characterModule = module {
    singleOf(::CharactersRepositoryImpl).bind<CharactersRepository>()
    viewModelOf(::CharactersViewModel)
}