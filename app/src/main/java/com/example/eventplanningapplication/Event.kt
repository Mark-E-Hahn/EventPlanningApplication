package com.example.eventplanningapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val date: Long,
    val location: String,
    val reminders: List<String>,
    val tasks: List<String>
)