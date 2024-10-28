package org.rick.and.morty.navigation

import androidx.navigation.NavHostController

object Navigator {
    private lateinit var navHostController: NavHostController

    fun setNavigator(controller: NavHostController) {
        navHostController = controller
    }

    fun getNavigator() = navHostController
}