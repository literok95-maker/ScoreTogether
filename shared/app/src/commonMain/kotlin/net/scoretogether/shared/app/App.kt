package net.scoretogether.shared.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.scoretogether.shared.app.ui.components.AppBottomBar
import net.scoretogether.shared.app.ui.components.AppBottomBarItem
import net.scoretogether.shared.app.ui.components.AppTopBar
import net.scoretogether.shared.app.ui.theme.AppTheme

@Composable
fun app() {
    AppTheme {
        Scaffold(
            topBar = { AppTopBar(title = "ScoreTogether") },
            bottomBar = {
                AppBottomBar(
                    items =
                        listOf(
                            AppBottomBarItem(label = "Home", icon = { Text("\uD83C\uDFE0") }),
                            AppBottomBarItem(label = "Settings", icon = { Text("\u2699\uFE0F") }),
                        ),
                    selectedIndex = 0,
                    onItemSelected = {},
                )
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // TODO implement app UI
            }
        }
    }
}
