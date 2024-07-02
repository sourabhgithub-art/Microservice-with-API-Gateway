package com.microservice.quiz_service.Controller;
import com.microservice.quiz_service.Model.Quiz;
import com.microservice.quiz_service.Model.Response;
import com.microservice.quiz_service.Service.QuizService;
import com.microservice.quiz_service.dto.QuestionDto;
import com.microservice.quiz_service.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto req) {
        return quizService.createQuiz(req.getTopic(), req.getTitle(), req.getNumQue());
        // return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }





     @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionDto>> gteQuiz(@PathVariable int id){
       try {
           //Quiz q =  quizService.getQuiz(id);
           List<QuestionDto> qDto = quizService.getQuizQuestions(id);

           return new ResponseEntity<>(qDto,HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        int marks = quizService.getScore(id,response);
        return new ResponseEntity<>(marks, HttpStatus.OK);

    }
}
