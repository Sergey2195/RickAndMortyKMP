package org.rick.and.morty

import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController
import org.rick.and.morty.di.initKoin
import org.rick.and.morty.navigation.Navigator

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    },
    content = {
        val navHostController = rememberNavController()
        Navigator.setNavigator(navHostController)
        App(navHostController)
    }
)