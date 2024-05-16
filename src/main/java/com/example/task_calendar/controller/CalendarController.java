package com.example.task_calendar.controller;

import com.example.task_calendar.dto.CalendarDTO;
import com.example.task_calendar.dto.SignUpDTO;
import com.example.task_calendar.dto.UserDTO;
import com.example.task_calendar.entity.Calendar;
import com.example.task_calendar.entity.User;
import com.example.task_calendar.exception.ApiRequestException;
import com.example.task_calendar.response.ResponseHandler;
import com.example.task_calendar.service.calendar.CalendarService;
import com.example.task_calendar.util.UserUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @PostMapping("/calendar")
    public ResponseEntity<?> addCalendar(@Valid @RequestBody CalendarDTO calendarDTO) {

        Calendar calendar = calendarService.createCalendar(calendarDTO);

        return ResponseHandler.responseBuilder("Created calendar successfully", HttpStatus.OK, calendar);

    }

    @GetMapping("/calendar")
    public ResponseEntity<?> getAllCalendarWithTasks() {

        List<Calendar> calendars = calendarService.getUserCalendars();

        return ResponseHandler.responseBuilder("Get All Calendar With Tasks successfully", HttpStatus.OK, calendars);

    }

}
