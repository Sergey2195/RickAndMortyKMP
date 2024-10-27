package org.rick.and.morty

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.rick.and.morty.navigation.MainNavigationNavHost

@Composable
@Preview
fun App(controller: NavHostController) {
    MaterialTheme {
        KoinContext {
            MainNavigationNavHost(controller)
        }
    }
}