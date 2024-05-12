package com.example.task_calendar.service.task;

import com.example.task_calendar.dto.TaskDTO;
import com.example.task_calendar.entity.Calendar;
import com.example.task_calendar.entity.Task;
import com.example.task_calendar.repository.CalendarRepository;
import com.example.task_calendar.repository.TaskRepository;
import com.example.task_calendar.repository.UserRepository;
import com.example.task_calendar.util.DateUtil;
import com.example.task_calendar.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Task createTask(TaskDTO taskDTO) {
        Optional<Calendar> calendarOptional = calendarRepository.findById(taskDTO.getCalendarId());
        if (calendarOptional.isPresent()) {
            Calendar calendar = calendarOptional.get();

            Task task = new Task();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            LocalDateTime startTime = DateUtil.parseStringToLocalDateTime(taskDTO.getStartTime());
            task.setStartTime(startTime);
            LocalDateTime endTime = DateUtil.parseStringToLocalDateTime(taskDTO.getEndTime());
            task.setEndTime(endTime);
            task.setCalendar(calendar);

            Task createdTask = taskRepository.save(task);

            calendar.add(task);

            return createdTask;
        } else {
            return null;
        }
    }

}
