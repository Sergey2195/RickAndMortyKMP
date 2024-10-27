import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.graphics.vector.ImageVector

enum class Tabs(
    val title: String,
    val icon: ImageVector
) {
    CHARACTERS("Персонажи", Icons.Filled.Call),
    EPISODES("Эпизоды", Icons.Filled.Done),
    LOCATIONS("Локации", Icons.Filled.Edit)
}