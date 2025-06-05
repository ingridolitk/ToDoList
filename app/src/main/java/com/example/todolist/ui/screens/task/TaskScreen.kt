package com.example.todolist.ui.screens.task

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.todolist.data.models.ToDoTask
import com.example.todolist.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    selectTask: ToDoTask
) {

    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = navigateToListScreen,
                selectTask = selectTask
            )
        },
        content = {}
    )
}