package org.rick.and.morty.locations.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.rick.and.morty.locations.LocationsViewModel

val locationsModule = module {
    viewModelOf(::LocationsViewModel)
}