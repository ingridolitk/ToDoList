package com.example.todolist.navigation.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist.ui.screens.task.TaskScreen
import com.example.todolist.ui.viewmodel.SharedViewModel
import com.example.todolist.util.Action
import com.example.todolist.util.Constants.TASK_ARGUMENT_KEY
import com.example.todolist.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->

        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId = taskId)

        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        selectedTask?.let {
            TaskScreen(
                navigateToListScreen = navigateToListScreen,
                selectTask = it
            )
        }
    }
}