package com.example.task_calendar.controller;

import com.example.task_calendar.dto.GenerateTaskDTO.GenerateTaskReqDTO;
import com.example.task_calendar.dto.GenerateTaskDTO.GenerateTaskResDTO;
import com.example.task_calendar.service.generateTask.GenerateTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate-calendar")
public class GenerateTaskController {

    @Autowired
    private GenerateTaskService generateTaskService;

    @PostMapping("")
    public GenerateTaskResDTO generateCalendar (@RequestBody GenerateTaskReqDTO requestCalendarDTO) {
        return generateTaskService.generateCalendar(requestCalendarDTO);
    }
}
