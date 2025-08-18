package net.score.volley.demo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data class SportEventDetailsScreen(val event: SportEvent) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(event.name, style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            Text("Level: ${'$'}{event.playerLevel}")
            Text("Starts: ${'$'}{event.startTime}")
            Text("Needed participants: ${'$'}{event.requiredParticipants}")
            Spacer(Modifier.height(24.dp))
            Button(onClick = { navigator.pop() }) {
                Text("Back")
            }
        }
    }
}
