package org.rick.and.morty.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.rick.and.morty.character.detail.api.di.characterDetailModel
import org.rick.and.morty.characters.api.di.characterModule
import org.rick.and.morty.episodes.di.episodesModule
import org.rick.and.morty.locations.di.locationsModule
import org.rick.and.morty.navigation.di.navigationModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            navigationModule,
            characterModule,
            episodesModule,
            locationsModule,
            characterDetailModel
        )
    }
}