package com.example.task_calendar.service.task;


import com.example.task_calendar.dto.TaskDTO;
import com.example.task_calendar.entity.Task;

import java.util.List;


public interface TaskService {
    Task createTask(TaskDTO taskDTO);

    Task deleteTask(Long id);

    List<Task> createManyTasks(List<TaskDTO> taskDTOList);
}
