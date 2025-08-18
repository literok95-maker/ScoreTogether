package net.score.volley.demo.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.score.volley.demo.SportEvent
import net.score.volley.demo.domain.GetSportEventsUseCase

/**
 * ViewModel that exposes sports events for the UI.
 */
class SportsEventsViewModel(
    private val getSportEventsUseCase: GetSportEventsUseCase,
) {
    private val _events = MutableStateFlow<List<SportEvent>>(emptyList())
    val events: StateFlow<List<SportEvent>> = _events

    init {
        loadEvents()
    }

    private fun loadEvents() {
        _events.value = getSportEventsUseCase()
    }
}
