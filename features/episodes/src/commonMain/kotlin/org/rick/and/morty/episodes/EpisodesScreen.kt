package org.rick.and.morty.episodes

import Design
import MainBottomNavigation
import Tab
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EpisodesScreen(episodesViewModel: EpisodesViewModel) {
    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                selectedTab = Tab.EPISODES,
                onClickIndex = episodesViewModel::onClickBottomNavigation
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Design.Colors.backgroundPrimary)
                .statusBarsPadding()
        ) {
            Text("EpisodesScreen", color = Design.Colors.textPrimary)
        }
    }
}