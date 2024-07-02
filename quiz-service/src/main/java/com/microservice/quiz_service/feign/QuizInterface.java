package com.microservice.quiz_service.feign;

import com.microservice.quiz_service.Model.Response;
import com.microservice.quiz_service.dto.QuestionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String topic, @RequestParam Integer numQue);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionDto>> getQuestions(@RequestBody List<Integer> request);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> res);
}
