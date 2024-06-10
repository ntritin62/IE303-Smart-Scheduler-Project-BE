package com.example.task_calendar.service.genTask;

import com.example.task_calendar.dto.GenerateTaskDTO.GenTaskRequest;
import com.example.task_calendar.dto.GenerateTaskDTO.GenTaskResponse;
import com.example.task_calendar.util.UserUtil;
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
    private final UserUtil userUtil;

    @Override
    public GenTaskResponse generateTask(GenTaskRequest request) {
        // Add exist times prompt when regenerate
        String existTimes = "";
        if (request.existTimes() != null) {
            existTimes = String.format(", don't include these times %s because it was wrong", String.join(", ", request.existTimes()));
        }

        LocalDateTime predictedStartTime = assistant.predictStartTime(userUtil.getCurrentUsername(), request.title(), request.appliedDate(), existTimes);

        return new GenTaskResponse(
                request.title(),
                request.calendarId(),
                request.repeat(),
                request.description(),
                predictedStartTime,
                predictedStartTime.plusMinutes(request.estimatedTime()),
                request.isRecurring(),
                request.notification()
        );
    }

}
