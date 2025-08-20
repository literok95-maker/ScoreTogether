@file:Suppress("FunctionName")

package net.scoretogether.shared.app.discover

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value

interface DiscoverComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        data object Stub : Child
    }
}

class DefaultDiscoverComponent(
    componentContext: ComponentContext,
) : DiscoverComponent,
    ComponentContext by componentContext {
    private val navigation = StackNavigation<Unit>()

    override val childStack: Value<ChildStack<Unit, DiscoverComponent.Child>> =
        childStack<ComponentContext, Unit, DiscoverComponent.Child>(
            source = navigation,
            serializer = null,
            initialStack = { listOf(Unit) },
            handleBackButton = true,
            childFactory = { _: Unit, _: ComponentContext -> DiscoverComponent.Child.Stub },
        )
}

@Composable
fun DiscoverContent(component: DiscoverComponent) {
    Children(stack = component.childStack) { child ->
        when (child.instance) {
            DiscoverComponent.Child.Stub -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("Discover screen")
                }
            }
        }
    }
}
