package net.score.volley.demo

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Suppress("FunctionName")
@Composable
fun TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val options = tab.options
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            options.icon?.let { painter ->
                Icon(painter, contentDescription = options.title)
            }
        },
        label = { Text(options.title) },
    )
}
