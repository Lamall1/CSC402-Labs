
package sa.edu.iau.cshj.studyplanner

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun TaskDetailRoute(
    title: String,
    description: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    TaskDetailScreen(
        uiState = TaskDetailUiState(
            title = title,
            description = description
        ),
        onShareClick = {
            val send = Intent(Intent.ACTION_SEND).apply {
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Study Task: $title\n."
                )
                type = "text/plain"
            }

            context.startActivity(
                Intent.createChooser(send, "Share via")
            )
        },
        onBackClick = onBackClick
    )
}
