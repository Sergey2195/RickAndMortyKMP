package org.rick.and.morty.characters

import Design
import MainBottomNavigation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CharactersScreen(charactersViewModel: CharactersViewModel) {
    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                selectedTab = Tabs.CHARACTERS,
                onClickIndex = charactersViewModel::onClickBottomNavigation
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Design.Colors.backgroundPrimary)
                .statusBarsPadding()
        ) {
            Text("CharactersScreen", color = Design.Colors.textPrimary)
        }
    }
}