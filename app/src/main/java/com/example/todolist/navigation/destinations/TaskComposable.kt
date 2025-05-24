package com.example.todolist.navigation.destinations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist.data.models.ToDoTask
import com.example.todolist.ui.screens.task.TaskScreen
import com.example.todolist.util.Action
import com.example.todolist.util.Constants.TASK_ARGUMENT_KEY
import com.example.todolist.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    selectTask: ToDoTask,
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
        type = NavType.IntType
    })){ navBackStackEntry ->
        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY)
        Log.d("TaskComposable", taskId.toString())

        TaskScreen(navigateToListScreen = navigateToListScreen, selectTask = selectTask)
    }
}