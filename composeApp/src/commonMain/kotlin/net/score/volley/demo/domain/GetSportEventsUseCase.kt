package net.score.volley.demo.domain

import net.score.volley.demo.SportEvent
import net.score.volley.demo.data.SportEventRepository

/**
 * Use case that retrieves sports events from the repository.
 */
class GetSportEventsUseCase(
    private val repository: SportEventRepository,
) {
    operator fun invoke(): List<SportEvent> = repository.getEvents()
}
