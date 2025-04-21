package com.example.todolist.data.models

import androidx.compose.ui.graphics.Color
import com.example.todolist.ui.theme.HighPriorityColor
import com.example.todolist.ui.theme.LowPriorityColor
import com.example.todolist.ui.theme.MediumPriorityColor
import com.example.todolist.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}