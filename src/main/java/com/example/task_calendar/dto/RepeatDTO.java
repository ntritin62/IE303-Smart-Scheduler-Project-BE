package com.example.task_calendar.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RepeatDTO {
    private String type;

    private List<String> dayOfWeek;

    private int repeatGap;

    private String endDate;
}
