package com.example.todolist.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val Purple40 = Color(0xffaa66cc)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)
const val isLight: Boolean = true

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else Color.LightGray

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple40 else Color.Black