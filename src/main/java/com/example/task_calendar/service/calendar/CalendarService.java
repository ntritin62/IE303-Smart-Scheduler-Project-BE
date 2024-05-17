package com.example.task_calendar.service.calendar;

import com.example.task_calendar.dto.CalendarDTO;
import com.example.task_calendar.entity.Calendar;

import java.util.List;

public interface CalendarService {
    Calendar createCalendar(CalendarDTO calendarDTO);

    void deleteCalendar(long calendarId);
    List<Calendar> getUserCalendars(int year, int month, int day);
}
