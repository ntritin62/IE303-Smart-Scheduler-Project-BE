package com.example.task_calendar.dto.GenerateTaskDTO;

public record GenerateTaskReqDTO(
        String title,
        Integer estimatedTime,
        String calendarName,
        Repeat repeat,
        String description
) {
}
