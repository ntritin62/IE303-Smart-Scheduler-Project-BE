package com.example.task_calendar.controller;

import com.example.task_calendar.dto.GenerateTaskDTO.GenTaskRequest;
import com.example.task_calendar.dto.GenerateTaskDTO.GenTaskResponse;
import com.example.task_calendar.service.genTask.GenTaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generate")
public class GenerateTaskController {

    private final GenTaskService genTaskService;

    @PostMapping("/task")
    public GenTaskResponse generateTask(@RequestBody GenTaskRequest request) {
        return genTaskService.generateTask(request);
    }
}
