package net.scoretogether.app.ios

import androidx.compose.ui.window.ComposeUIViewController
import net.scoretogether.shared.app.app
import net.scoretogether.shared.di.initKoin
import org.koin.dsl.module
import platform.UIKit.UIViewController

private val platformModule = module { }

@Suppress("FunctionName")
fun MainViewController(): UIViewController {
    initKoin(platformModule)
    return ComposeUIViewController { app() }
}
