package net.scoretogether.shared.app.ui.components

import kotlin.test.Test
import kotlin.test.assertEquals

class AppBottomBarItemTest {
    @Test
    fun itemStoresLabel() {
        val item = AppBottomBarItem(label = "Home", icon = {})
        assertEquals("Home", item.label)
    }
}
