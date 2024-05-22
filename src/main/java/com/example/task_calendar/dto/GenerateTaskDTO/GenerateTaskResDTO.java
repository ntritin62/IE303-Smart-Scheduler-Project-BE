package com.example.task_calendar.dto.GenerateTaskDTO;

public record GenerateTaskResDTO(
        String title,
        Integer estimatedTime,
        String calendarName,
        Repeat repeat,
        String description,
        PredictTime startTime,
        PredictTime endTime
) {
}
