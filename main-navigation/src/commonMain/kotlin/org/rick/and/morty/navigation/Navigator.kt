package org.rick.and.morty.navigation

import androidx.navigation.NavHostController

object Navigator {
    private lateinit var navHostController: NavHostController

    fun setNavigator(controller: NavHostController) {
        navHostController = controller
    }

    fun getNavigator() = navHostController

    fun navigateWithSingleInstance(route: String) {
        val isRouteExist = navHostController.currentBackStack.value.any { it.destination.route == route }

        if (isRouteExist) {
            navHostController.popBackStack(route = route, inclusive = false)
        } else {
            navHostController.navigate(route = route)
        }
    }
}