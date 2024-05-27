package com.example.task_calendar.dto.GenerateTaskDTO;

public record GenTaskRequest(
        Integer userId,
        String title,
        Integer estimatedTime,
        Integer calendarId,
        Repeat repeat,
        String description
) {
}
