package org.rick.and.morty

import Design
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.rick.and.morty.navigation.MainNavigationNavHost

@Composable
@Preview
fun App(controller: NavHostController) {
    MaterialTheme(
        colors = darkColors(
            primary = Design.Colors.backgroundPrimary,
            secondary = Design.Colors.backgroundSecondary
        )
    ) {
        KoinContext {
            MainNavigationNavHost(controller)
        }
    }
}