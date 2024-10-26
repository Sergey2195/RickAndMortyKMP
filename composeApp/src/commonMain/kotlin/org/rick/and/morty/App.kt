package org.rick.and.morty

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rick.and.morty.navigation.MainNavigationNavHost

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainNavigationNavHost()
    }
}