package com.microservice.quiz_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qId;
    private String difficultyLevel;
    private String topic;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String correctAnswer;
}
