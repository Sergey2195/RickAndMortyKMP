package org.rick.and.morty

import androidx.compose.ui.window.ComposeUIViewController
import org.rick.and.morty.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() },
    content = { App() }
)