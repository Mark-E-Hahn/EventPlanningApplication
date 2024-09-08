package com.example.eventplanningapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val eventDao: EventDao = EventDatabase.getDatabase(application).eventDao()
    private val _allEvents: LiveData<List<Event>> = eventDao.getAllEvents()

    val allEvents: LiveData<List<Event>>
        get() = _allEvents

    fun insertEvent(event: Event) {
        viewModelScope.launch(Dispatchers.IO) {
            eventDao.insertEvent(event)
        }
    }

    fun getEventById(id: Int): LiveData<Event?> {
        return eventDao.getEventById(id)}

    fun deleteEvent(event: Event) {
        viewModelScope.launch(Dispatchers.IO) {
            eventDao.deleteEvent(event)
        }
    }

    fun saveEvent(title: String, description: String, eventDate: Long, location: String) {
        val event = Event(
            title = title,
            description = description,
            date = eventDate,
            location = location,
            reminders = emptyList(),
            tasks = emptyList()
        )

        viewModelScope.launch(Dispatchers.IO) {
            eventDao.insertEvent(event)
        }
    }
}