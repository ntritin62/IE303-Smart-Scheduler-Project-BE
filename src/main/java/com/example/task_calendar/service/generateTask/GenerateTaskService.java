package com.example.task_calendar.service.generateTask;

import com.example.task_calendar.dto.GenerateTaskDTO.GenerateTaskReqDTO;
import com.example.task_calendar.dto.GenerateTaskDTO.GenerateTaskResDTO;
import com.example.task_calendar.dto.GenerateTaskDTO.PredictTime;
import com.example.task_calendar.dto.GenerateTaskDTO.TimePeriod;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GenerateTaskService {

    private final OpenAiChatModel model;

    public GenerateTaskService(@Value("${OPENAI_API_KEY}") final String apiKey) {
        this.model = OpenAiChatModel.withApiKey(apiKey);
    }

    public GenerateTaskResDTO generateCalendar(GenerateTaskReqDTO requestCalendarDTO) {
        return new GenerateTaskResDTO(
                requestCalendarDTO.title(),
                requestCalendarDTO.estimatedTime(),
                requestCalendarDTO.calendarName(),
                requestCalendarDTO.repeat(),
                requestCalendarDTO.description(),
                new PredictTime(1, 30, TimePeriod.AM),
                new PredictTime(2, 30, TimePeriod.AM)
        );
    }
}
