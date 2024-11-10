package org.rick.and.morty.character.detail.api.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.rick.and.morty.character.detail.api.CharacterDetailViewModel

public val characterDetailModel: Module = module {
    viewModelOf(::CharacterDetailViewModel)
}