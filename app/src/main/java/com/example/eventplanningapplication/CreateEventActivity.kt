package com.example.eventplanningapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CreateEventActivity : AppCompatActivity() {
    private lateinit var etEventTitle: EditText
    private lateinit var etEventDescription: EditText
    private lateinit var etEventLocation: EditText
    private lateinit var btnSetDate: Button
    private lateinit var btnSaveEvent: Button

    private var eventDate: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        etEventTitle = findViewById(R.id.etEventTitle)
        etEventDescription = findViewById(R.id.etEventDescription)
        etEventLocation = findViewById(R.id.etEventLocation)
        btnSetDate = findViewById(R.id.btnSetDate)
        btnSaveEvent = findViewById(R.id.btnSaveEvent)

        btnSetDate.setOnClickListener { showDatePicker() }
        btnSaveEvent.setOnClickListener { saveEvent() }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedCalendar = Calendar.getInstance()
            selectedCalendar.set(selectedYear, selectedMonth, selectedDay)
            eventDate = selectedCalendar.timeInMillis
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun saveEvent() {
        val title = etEventTitle.text.toString()
        val description = etEventDescription.text.toString()
        val location = etEventLocation.text.toString()

        val event = Event(
            title = title,
            description = description,
            date = eventDate,
            location = location,
            reminders= emptyList(),
            tasks = emptyList()
        )

    }
}
