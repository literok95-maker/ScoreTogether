package net.score.volley.demo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import net.score.volley.demo.data.InMemorySportEventRepository
import net.score.volley.demo.domain.GetSportEventsUseCase
import net.score.volley.demo.presentation.SportsEventsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val repository = remember { InMemorySportEventRepository() }
        val useCase = remember { GetSportEventsUseCase(repository) }
        val viewModel = remember { SportsEventsViewModel(useCase) }
        val events by viewModel.events.collectAsState()
        SportsEventsScreen(events)
    }
}
