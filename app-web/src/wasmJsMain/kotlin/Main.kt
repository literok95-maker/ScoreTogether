import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import net.scoretogether.shared.app.app
import net.scoretogether.shared.di.initKoin
import org.koin.dsl.module

private val platformModule = module { }

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin(platformModule)
    CanvasBasedWindow("App") { app() }
}
