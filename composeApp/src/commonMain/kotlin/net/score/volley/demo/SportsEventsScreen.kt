package net.score.volley.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import net.score.volley.demo.data.InMemorySportEventRepository
import net.score.volley.demo.domain.GetSportEventsUseCase
import net.score.volley.demo.presentation.SportsEventsViewModel

/**
 * Displays the list of sport events inside the [SportsEventsTab].
 */
object SportsEventsScreen : Screen {
    @Composable
    override fun Content() {
        val repository = remember { InMemorySportEventRepository() }
        val useCase = remember { GetSportEventsUseCase(repository) }
        val viewModel = remember { SportsEventsViewModel(useCase) }
        val events by viewModel.events.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
        ) {
            items(events) { event ->
                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { navigator.push(SportEventDetailsScreen(event)) },
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(event.name, style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(4.dp))
                        Text("Level: ${'$'}{event.playerLevel}")
                        Text("Starts: ${'$'}{event.startTime}")
                        Text("Needed participants: ${'$'}{event.requiredParticipants}")
                    }
                }
            }
        }
    }
}
