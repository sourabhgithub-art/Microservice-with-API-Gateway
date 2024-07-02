package com.microservice.quiz_service.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.patterns.TypePatternQuestions;


import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String topic;
    @ElementCollection
    private List<Integer> questionsIds;

}
