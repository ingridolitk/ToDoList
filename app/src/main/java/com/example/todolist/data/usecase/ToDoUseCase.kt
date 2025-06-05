package com.example.todolist.data.usecase

import com.example.todolist.data.models.ToDoTask
import com.example.todolist.data.repositories.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class ToDoUseCase @Inject constructor(
    private val repository: ToDoRepository
) {

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> =
         repository.getSelectedTask(taskId)

     fun getAllTasks(): Flow<List<ToDoTask>> =
        repository.getAllTasks

}