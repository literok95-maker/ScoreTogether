@file:Suppress("MagicNumber")

package net.score.volley.demo.data

import net.score.volley.demo.SportEvent

/**
 * Simple in-memory implementation of [SportEventRepository].
 */
class InMemorySportEventRepository : SportEventRepository {
    private val events =
        listOf(
            SportEvent("Yoga Session", "Beginner", "07:30", 12),
            SportEvent("Swimming Training", "Intermediate", "09:00", 8),
            SportEvent("Cycling Group Ride", "Advanced", "10:30", 15),
            SportEvent("Pilates Class", "Beginner", "11:00", 10),
            SportEvent("CrossFit Workout", "Advanced", "12:00", 6),
            SportEvent("Basketball Game", "Intermediate", "14:00", 10),
            SportEvent("Boxing Training", "Advanced", "15:30", 5),
            SportEvent("Table Tennis", "Beginner", "16:00", 4),
            SportEvent("Dance Fitness", "Intermediate", "17:00", 20),
            SportEvent("Evening Volleyball", "Intermediate", "19:00", 12),
            SportEvent("Night Run", "Beginner", "21:00", 7),
            SportEvent("Martial Arts", "Advanced", "21:30", 6),
        )

    override fun getEvents(): List<SportEvent> = events
}
