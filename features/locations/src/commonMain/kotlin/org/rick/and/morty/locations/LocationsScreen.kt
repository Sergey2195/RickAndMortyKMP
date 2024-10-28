package org.rick.and.morty.locations

import Design
import MainBottomNavigation
import Tabs
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LocationsScreen(locationsViewModel: LocationsViewModel) {
    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                selectedTab = Tabs.LOCATIONS,
                onClickIndex = locationsViewModel::onClickBottomNavigation
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Design.Colors.backgroundPrimary)
                .statusBarsPadding()
        ) {
            Text("LocationsScreen", color = Design.Colors.textPrimary)
        }
    }
}