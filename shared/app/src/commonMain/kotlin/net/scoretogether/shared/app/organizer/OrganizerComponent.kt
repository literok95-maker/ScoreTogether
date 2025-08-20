@file:Suppress("FunctionName")

package net.scoretogether.shared.app.organizer

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

interface OrganizerComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        data object Stub : Child
    }
}

class DefaultOrganizerComponent(
    componentContext: ComponentContext,
) : OrganizerComponent,
    ComponentContext by componentContext {
    private val navigation = StackNavigation<Unit>()

    override val childStack: Value<ChildStack<Unit, OrganizerComponent.Child>> =
        childStack<ComponentContext, Unit, OrganizerComponent.Child>(
            source = navigation,
            serializer = null,
            initialStack = { listOf(Unit) },
            handleBackButton = true,
            childFactory = { _: Unit, _: ComponentContext -> OrganizerComponent.Child.Stub },
        )
}

@Composable
fun OrganizerContent(component: OrganizerComponent) {
    Children(stack = component.childStack) { child ->
        when (child.instance) {
            OrganizerComponent.Child.Stub -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("Organizer screen")
                }
            }
        }
    }
}
