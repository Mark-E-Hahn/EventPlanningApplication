package com.example.eventplanningapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var eventViewModel: EventViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EventAdapter()
        recyclerView.adapter = adapter

        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        eventViewModel.allEvents.observe(this, Observer { events ->

            events?.let { adapter.submitList(it) }
        })

        val newEvent = Event(
            title = "New Event",
            description = "Event Description",
            date = System.currentTimeMillis(),
            location = "Event Location",
            reminders = emptyList(),
            tasks = emptyList()
        )
        eventViewModel.insertEvent(newEvent)
    }
}
