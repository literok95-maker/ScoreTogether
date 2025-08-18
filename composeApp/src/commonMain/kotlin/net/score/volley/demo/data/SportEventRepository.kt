package net.score.volley.demo.data

import net.score.volley.demo.SportEvent

/**
 * Repository for accessing [SportEvent]s.
 */
interface SportEventRepository {
    fun getEvents(): List<SportEvent>
}
