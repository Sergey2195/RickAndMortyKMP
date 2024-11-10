package org.rick.and.morty.character.detail.api.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rick.and.morty.character.detail.api.CharacterDetailViewModel
import org.rick.and.morty.character.detail.internal.data.CharacterDetailRepositoryImpl
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailRepository

public val characterDetailModel: Module = module {
    viewModelOf(::CharacterDetailViewModel)
    singleOf(::CharacterDetailRepositoryImpl).bind<CharacterDetailRepository>()
}