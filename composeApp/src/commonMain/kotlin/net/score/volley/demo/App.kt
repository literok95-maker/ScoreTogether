package net.score.volley.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
@Suppress("FunctionName")
fun App() {
    MaterialTheme {
        TabNavigator(SportsEventsTab) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        TabNavigationItem(SportsEventsTab)
                        TabNavigationItem(ProfileTab)
                    }
                },
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    CurrentTab()
                }
            }
        }
    }
}
