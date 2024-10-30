import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainBottomNavigation(
    selectedTab: Tab,
    onClickIndex: (Tab) -> Unit
) {
    BottomNavigation {
        Tab.entries.forEach { tab ->
            BottomNavigationItem(
                selected = selectedTab == tab,
                onClick = { onClickIndex(tab) },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        color = if (selectedTab == tab) Color.White else Design.Colors.textPrimary
                    )
                },
                modifier = Modifier
                    .navigationBarsPadding()
            )
        }
    }
}