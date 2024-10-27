import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainBottomNavigation(
    selectedTab: Tabs,
    onClickIndex: (Tabs) -> Unit
) {
    BottomNavigation(
        modifier = Modifier
    ) {
        Tabs.entries.forEach { tab ->
            BottomNavigationItem(
                selected = selectedTab == tab,
                onClick = { onClickIndex(tab) },
                icon = { Icon(tab.icon, null) },
                label = { Text(tab.title) }
            )
        }
    }
}