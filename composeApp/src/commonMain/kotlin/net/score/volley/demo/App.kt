package net.score.volley.demo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val events = listOf(
            SportEvent("Morning Run", "Beginner", "08:00", 5),
            SportEvent("Evening Soccer", "Intermediate", "18:30", 10),
            SportEvent("Tennis Match", "Advanced", "20:00", 4),
        )
        SportsEventsScreen(events)
    }
}
