import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import net.scoretogether.shared.app.app

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("App") { app() }
}
