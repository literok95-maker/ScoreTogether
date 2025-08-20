package net.scoretogether.shared.app.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import net.scoretogether.shared.app.discover.DefaultDiscoverComponent
import net.scoretogether.shared.app.discover.DiscoverComponent
import net.scoretogether.shared.app.organizer.DefaultOrganizerComponent
import net.scoretogether.shared.app.organizer.OrganizerComponent

interface RootComponent {
    val selectedTab: Value<Tab>
    val discoverStack: Value<ChildStack<*, DiscoverComponent>>
    val organizerStack: Value<ChildStack<*, OrganizerComponent>>

    fun onTabSelect(tab: Tab)

    enum class Tab { DISCOVER, ORGANIZER }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent,
    ComponentContext by componentContext {
    private val _selectedTab = MutableValue(RootComponent.Tab.DISCOVER)
    override val selectedTab: Value<RootComponent.Tab> = _selectedTab

    private val discoverNavigation = StackNavigation<Unit>()
    override val discoverStack: Value<ChildStack<Unit, DiscoverComponent>> =
        childStack<ComponentContext, Unit, DiscoverComponent>(
            source = discoverNavigation,
            serializer = null,
            initialStack = { listOf(Unit) },
            handleBackButton = true,
            childFactory = { _: Unit, ctx: ComponentContext -> DefaultDiscoverComponent(ctx) },
        )

    private val organizerNavigation = StackNavigation<Unit>()
    override val organizerStack: Value<ChildStack<Unit, OrganizerComponent>> =
        childStack<ComponentContext, Unit, OrganizerComponent>(
            source = organizerNavigation,
            serializer = null,
            initialStack = { listOf(Unit) },
            handleBackButton = true,
            childFactory = { _: Unit, ctx: ComponentContext -> DefaultOrganizerComponent(ctx) },
        )

    override fun onTabSelect(tab: RootComponent.Tab) {
        _selectedTab.value = tab
    }
}
