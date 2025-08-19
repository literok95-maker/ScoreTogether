package net.score.volley.demo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object SportsEventsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Filled.List)
            return TabOptions(
                index = 0u,
                title = "Мои события",
                icon = icon,
            )
        }

    @Composable
    override fun Content() {
        Navigator(SportsEventsScreen)
    }
}
