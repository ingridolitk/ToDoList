package com.example.todolist.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.models.ToDoTask
import com.example.todolist.data.usecase.ToDoUseCase
import com.example.todolist.util.RequestState
import com.example.todolist.util.SearchAppBarState
import com.example.todolist.util.empty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val toDoUseCase: ToDoUseCase
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf(String.empty())

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTask = _selectedTask.asStateFlow()

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                toDoUseCase.getAllTasks().collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception){
            _allTasks.value = RequestState.Error(e)
        }

    }

    fun getSelectedTask(taskId: Int?) {
        viewModelScope.launch {
            if (taskId != null) {
                toDoUseCase.getSelectedTask(taskId = taskId).collect { task ->
                    _selectedTask.value = task
                }
            }
        }
    }
}