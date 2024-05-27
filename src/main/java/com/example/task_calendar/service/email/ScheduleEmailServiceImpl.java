package com.example.task_calendar.service.email;

import com.example.task_calendar.entity.Calendar;
import com.example.task_calendar.entity.Task;
import com.example.task_calendar.service.calendar.CalendarService;
import com.example.task_calendar.service.calendar.CalendarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleEmailServiceImpl implements ScheduleEmailService{


    @Autowired
    private CalendarService calendarService;

    @Autowired
    private EmailService emailService;
    @Override
    @Scheduled(fixedRate = 60000)
    @Transactional(readOnly = true)
    public void checkToSendEmail() {
        System.out.println(123);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfDay = now.withHour(0).withMinute(0);
        LocalDateTime endOfDay = now.withHour(23).withMinute(59);


        List<Calendar> calendars = calendarService.getCalendars(startOfDay.getYear(), startOfDay.getMonthValue(), startOfDay.getDayOfMonth());
        for (Calendar calendar : calendars) {
            List<Task> filteredTasks = calendar.getTasks().stream()
                    .filter(task -> {
                        LocalDateTime dateTime = task.getStartTime();
                        return dateTime.isEqual(startOfDay) || dateTime.isEqual(endOfDay) ||
                                (dateTime.isAfter(startOfDay) && dateTime.isBefore(endOfDay));
                    })
                    .collect(Collectors.toList());
            calendar.setTasks(filteredTasks);
        }

        for (Calendar calendar : calendars) {
            String recipientEmail =  calendar.getUser().getEmail();

            for (Task event : calendar.getTasks()) {
                long minutesUntilEvent = ChronoUnit.MINUTES.between(now, event.getStartTime());
                if (minutesUntilEvent == 30) {
                    emailService.sendEmail(recipientEmail, "Reminder", "This is a reminder for your task in 30 minutes.");
                }
            }
        }
    }


}

