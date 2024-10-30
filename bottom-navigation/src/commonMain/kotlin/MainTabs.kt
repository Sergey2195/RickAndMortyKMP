import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.ui.graphics.vector.ImageVector

enum class Tab(
    val title: String,
    val icon: ImageVector
) {
    CHARACTERS("Персонажи", Icons.Filled.Person),
    EPISODES("Эпизоды", Icons.Filled.SmartDisplay),
    LOCATIONS("Локации", Icons.Filled.LocationOn)
}