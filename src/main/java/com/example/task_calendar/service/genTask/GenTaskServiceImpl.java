package com.example.task_calendar.service.genTask;

import com.example.task_calendar.dto.GenerateTaskDTO.GenTaskRequest;
import com.example.task_calendar.dto.GenerateTaskDTO.GenTaskResponse;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;

@Service
@RequiredArgsConstructor
public class GenTaskServiceImpl implements GenTaskService {

    private final Assistant assistant;

    @Override
    public GenTaskResponse generateTask(GenTaskRequest request) {
        LocalDateTime predictedStartTime = assistant.predictStartTime(request.userId(), request.title());
        return new GenTaskResponse(
                request.title(),
                request.calendarId(),
                request.repeat(),
                request.description(),
                predictedStartTime,
                predictedStartTime.plusMinutes(request.estimatedTime())
        );
    }

}
