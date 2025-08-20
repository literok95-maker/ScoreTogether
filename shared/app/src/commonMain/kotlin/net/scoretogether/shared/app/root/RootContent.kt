@file:Suppress("FunctionName")

package net.scoretogether.shared.app.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import net.scoretogether.shared.app.discover.DiscoverContent
import net.scoretogether.shared.app.organizer.OrganizerContent
import net.scoretogether.shared.app.ui.components.AppBottomBar
import net.scoretogether.shared.app.ui.components.AppBottomBarItem

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    val selectedTab by component.selectedTab.subscribeAsState()

    Scaffold(
        bottomBar = {
            AppBottomBar(
                items =
                    listOf(
                        AppBottomBarItem(label = "Discover", icon = { Text("\uD83D\uDD0D") }),
                        AppBottomBarItem(label = "Organizer", icon = { Text("\uD83D\uDCC5") }),
                    ),
                selectedIndex = selectedTab.ordinal,
                onItemSelected = { index ->
                    component.onTabSelect(RootComponent.Tab.values()[index])
                },
            )
        },
        modifier = modifier,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                RootComponent.Tab.DISCOVER -> {
                    Children(stack = component.discoverStack) { child ->
                        DiscoverContent(child.instance)
                    }
                }
                RootComponent.Tab.ORGANIZER -> {
                    Children(stack = component.organizerStack) { child ->
                        OrganizerContent(child.instance)
                    }
                }
            }
        }
    }
}
