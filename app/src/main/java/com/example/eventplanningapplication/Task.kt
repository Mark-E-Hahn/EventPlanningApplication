package com.example.eventplanningapplication

data class Task(
    val id: String,
    val eventId: String,
    val description: String,
    val isCompleted: Boolean
)