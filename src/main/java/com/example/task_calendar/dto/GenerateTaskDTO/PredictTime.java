package com.example.task_calendar.dto.GenerateTaskDTO;

public record PredictTime(
        Integer hour,
        Integer minute,
        TimePeriod period
) {
}
