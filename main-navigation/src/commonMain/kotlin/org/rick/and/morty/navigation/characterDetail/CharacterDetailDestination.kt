package org.rick.and.morty.navigation.characterDetail

import androidx.core.bundle.Bundle

object CharacterDetailDestination {
    const val route = "characterDetail/{id}"

    fun getConfigurationRoute(id:String): String {
        return route.replace("{id}", id)
    }

    fun getIdWithArguments(bundle: Bundle?): String {
        return bundle?.getString("id") ?: ""
    }
}