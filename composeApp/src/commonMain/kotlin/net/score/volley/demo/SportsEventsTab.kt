package net.score.volley.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import net.score.volley.demo.data.InMemorySportEventRepository
import net.score.volley.demo.domain.GetSportEventsUseCase
import net.score.volley.demo.presentation.SportsEventsViewModel
import androidx.compose.ui.graphics.vector.rememberVectorPainter

object SportsEventsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Filled.List)
            return TabOptions(
                index = 0u,
                title = "Мои события",
                icon = icon
            )
        }

    @Composable
    override fun Content() {
        val repository = remember { InMemorySportEventRepository() }
        val useCase = remember { GetSportEventsUseCase(repository) }
        val viewModel = remember { SportsEventsViewModel(useCase) }
        val events by viewModel.events.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(events) { event ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { navigator.push(SportEventDetailsScreen(event)) }
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
