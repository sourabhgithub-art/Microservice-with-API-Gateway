package com.microservice.quiz_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Long qId;
    private String topic;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
}
