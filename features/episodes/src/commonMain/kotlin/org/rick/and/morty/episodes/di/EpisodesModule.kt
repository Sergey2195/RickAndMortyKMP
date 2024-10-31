package org.rick.and.morty.episodes.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.rick.and.morty.episodes.EpisodesViewModel

val episodesModule = module {
    viewModelOf(::EpisodesViewModel)
}