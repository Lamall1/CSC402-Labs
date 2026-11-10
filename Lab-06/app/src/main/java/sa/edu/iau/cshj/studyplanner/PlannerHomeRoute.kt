
package sa.edu.iau.cshj.studyplanner

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Welcome!",
                totalTasks = 3,
                completedTasks = 0,
                tasks = listOf(
                    "Study for Programming Exam",
                    "Complete Mobile App Lab",
                    "Review Lecture Notes"
                )
            )
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onMarkTaskDone = {
            uiState = uiState.copy(
                completedTasks = (uiState.completedTasks + 1)
                    .coerceAtMost(uiState.totalTasks)
            )
        },
        onTaskClick = onTaskClick
    )
}
