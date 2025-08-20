package net.scoretogether.shared.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import net.scoretogether.shared.app.root.DefaultRootComponent
import net.scoretogether.shared.app.root.RootContent
import net.scoretogether.shared.app.ui.theme.AppTheme

@Composable
fun app() {
    AppTheme {
        val lifecycle = remember { LifecycleRegistry() }
        val root = remember { DefaultRootComponent(DefaultComponentContext(lifecycle = lifecycle)) }
        DisposableEffect(Unit) {
            lifecycle.onCreate()
            lifecycle.onStart()
            onDispose {
                lifecycle.onStop()
                lifecycle.onDestroy()
            }
        }
        RootContent(root)
    }
}
