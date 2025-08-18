package net.score.volley.demo.data

import net.score.volley.demo.SportEvent

/**
 * Simple in-memory implementation of [SportEventRepository].
 */
class InMemorySportEventRepository : SportEventRepository {
    private val events = listOf(
        SportEvent("Morning Run", "Beginner", "08:00", 5),
        SportEvent("Evening Soccer", "Intermediate", "18:30", 10),
        SportEvent("Tennis Match", "Advanced", "20:00", 4),
    )

    override fun getEvents(): List<SportEvent> = events
}
