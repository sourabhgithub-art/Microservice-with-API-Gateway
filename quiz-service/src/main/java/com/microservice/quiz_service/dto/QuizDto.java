package com.microservice.quiz_service.dto;

import com.microservice.quiz_service.Model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private String title;
    private String topic;
    private Integer numQue;
}
