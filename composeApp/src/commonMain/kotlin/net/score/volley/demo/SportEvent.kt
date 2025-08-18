package net.score.volley.demo

/**
 * Represents a sports event that users can join.
 */
data class SportEvent(
    val name: String,
    val playerLevel: String,
    val startTime: String,
    val requiredParticipants: Int,
)
