package com.example.eventplanningapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventDetailsActivity : AppCompatActivity() {
    private lateinit var rvTasks: RecyclerView
    private lateinit var btnAddTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        rvTasks = findViewById(R.id.rvTasks)
        btnAddTask = findViewById(R.id.btnAddTask)

        rvTasks.layoutManager = LinearLayoutManager(this)

        btnAddTask.setOnClickListener {

        }
    }
}