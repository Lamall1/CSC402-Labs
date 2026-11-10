
package sa.edu.iau.cshj.studyplanner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import sa.edu.iau.cshj.studyplanner.navigation.PlannerHome
import sa.edu.iau.cshj.studyplanner.navigation.TaskDetail

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlannerHome
    ) {
        composable<PlannerHome> {
            PlannerHomeRoute(
                onTaskClick = { title ->
                    val description = when (title) {
                        "Study for Programming Exam" ->
                            "Review programming concepts, practice coding exercises, and prepare for the upcoming exam."

                        "Complete Mobile App Lab" ->
                            "Finish the assigned lab tasks, test the application, and check that all requirements are completed."

                        "Review Lecture Notes" ->
                            "Read the lecture notes, summarize important topics, and review key concepts."

                        else -> ""
                    }

                    navController.navigate(
                        TaskDetail(
                            title = title,
                            description = description
                        )
                    )
                }
            )
        }

        composable<TaskDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<TaskDetail>()

            TaskDetailRoute(
                title = route.title,
                description = route.description,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
