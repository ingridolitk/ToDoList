package com.example.todolist.navigation

import androidx.navigation.NavHostController
import com.example.todolist.util.Action
import com.example.todolist.util.Constants.LIST_SCREEN

data class Screens(val navController: NavHostController){
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}"){
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")

    }
}
