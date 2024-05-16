package com.example.task_calendar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDTO {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotBlank(message = "startTime cannot be blank")
    private String startTime;
    @NotBlank(message = "endTime cannot be blank")
    private String endTime;
    @NotNull(message = "calendarID cannot be null")
    private Long calendarId;

}
