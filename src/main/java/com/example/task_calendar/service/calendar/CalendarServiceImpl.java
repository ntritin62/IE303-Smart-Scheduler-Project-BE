package com.example.task_calendar.service.calendar;

import com.example.task_calendar.dto.CalendarDTO;
import com.example.task_calendar.entity.Calendar;
import com.example.task_calendar.entity.User;
import com.example.task_calendar.repository.CalendarRepository;
import com.example.task_calendar.repository.UserRepository;
import com.example.task_calendar.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService{

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Calendar createCalendar(CalendarDTO calendarDTO) {
        User user = userRepository.findFirstByEmail(userUtil.getCurrentUsername());

        Calendar calendar = new Calendar();
        calendar.setTitle(calendarDTO.getTitle());
        calendar.setColor(calendarDTO.getColor());
        calendar.setUser(user);


        Calendar createdCalendar = calendarRepository.save(calendar);

        user.add(calendar);

        return createdCalendar;
    }

    @Override
    public void deleteCalendar(long calendarId) {

    }

    @Override
    public List<Calendar> getUserCalendars() {
        User user = userRepository.findFirstByEmail(userUtil.getCurrentUsername());
        if (user != null) {
            return calendarRepository.findByUserId(user.getId());
        } else {

            return Collections.emptyList();
        }
    }
}
