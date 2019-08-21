package ru.moviedbapp.slavicsky.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.skyhope.eventcalenderlibrary.model.Event
import kotlinx.android.synthetic.main.activity_calendar.*
import ru.moviedbapp.R
import java.util.*

class CalendarActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val calenderEvent = calender_event

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val event = Event(calendar.timeInMillis, "Test")
        calenderEvent.run {
            addEvent(event)
            initCalderItemClickCallback { dayContainerModel -> Log.d(TAG, dayContainerModel.date) }
        }
    }

    companion object {
        private val TAG = "CalenderTest"
    }

}
