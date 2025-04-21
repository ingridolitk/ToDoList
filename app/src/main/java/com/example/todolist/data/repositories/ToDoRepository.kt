package com.example.todolist.data.repositories

import com.example.todolist.data.ToDoDao
import com.example.todolist.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriorityTasks()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriorityTasks()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.selectedTasks(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTasks(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTasks(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTasks(toDoTask = toDoTask)
    }

    suspend fun deleteAllTask(toDoTask: ToDoTask) {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }
}