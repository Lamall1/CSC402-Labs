package sa.edu.iau.cshj.studyplanner

data class PlannerUiState(
    val greeting: String = "Welcome!",
    val totalTasks: Int = 0,
    val completedTasks: Int = 0,
    val tasks: List<String> = emptyList()
)