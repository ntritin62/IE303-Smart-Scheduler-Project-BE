package com.example.task_calendar.service.calendar;

import com.example.task_calendar.dto.CalendarDTO;
import com.example.task_calendar.entity.Calendar;

public interface CalendarService {
    Calendar createCalendar(CalendarDTO calendarDTO);

    void deleteCalendar(long calendarId);
}
