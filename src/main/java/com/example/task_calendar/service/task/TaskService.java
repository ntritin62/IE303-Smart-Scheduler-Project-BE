package com.example.task_calendar.service.task;


import com.example.task_calendar.dto.TaskDTO;
import com.example.task_calendar.entity.Task;


public interface TaskService {
    Task createTask(TaskDTO taskDTO);

    Task deleteTask(Long id);
}
