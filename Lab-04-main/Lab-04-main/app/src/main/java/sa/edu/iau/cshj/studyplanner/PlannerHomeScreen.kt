
package sa.edu.iau.cshj.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onMarkTaskDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    val progress = if (uiState.totalTasks > 0) {
        uiState.completedTasks.toFloat() / uiState.totalTasks
    } else {
        0f
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = uiState.greeting,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} done",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onMarkTaskDone,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text("Mark a task done")
        }
    }
}

@Preview(showBackground = true, name = "Nothing done yet")
@Composable
private fun PlannerHomePreview1() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Welcome!",
                totalTasks = 7,
                completedTasks = 0
            ),
            onMarkTaskDone = {}
        )
    }
}

@Preview(showBackground = true, name = "Everything done")
@Composable
private fun PlannerHomePreview2() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Welcome!",
                totalTasks = 7,
                completedTasks = 7
            ),
            onMarkTaskDone = {}
        )
    }
}

@Composable
fun PlannerHomeRoute() {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Welcome!",
                totalTasks = 7
            )
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onMarkTaskDone = {
            uiState = uiState.copy(
                completedTasks = uiState.completedTasks + 1
            )
        }
    )
}
