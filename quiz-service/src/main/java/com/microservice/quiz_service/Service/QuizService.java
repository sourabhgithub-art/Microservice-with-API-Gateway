package com.microservice.quiz_service.Service;


import com.microservice.quiz_service.Model.Question;
import com.microservice.quiz_service.Model.Quiz;
import com.microservice.quiz_service.Model.Response;
import com.microservice.quiz_service.Repository.QuizRepository;
import com.microservice.quiz_service.dto.QuestionDto;
import com.microservice.quiz_service.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizInterface quizInterface;
    @Autowired
    QuizRepository quizRepository;
    public ResponseEntity<String> createQuiz(String topic, String title, Integer numQue) {
        List<Integer> questions = quizInterface.generateQuestions(topic,numQue).getBody();
        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepository.save(quiz);
        return new ResponseEntity("Success", HttpStatus.CREATED);
    }

    public List<QuestionDto> getQuizQuestions(int id) {
        Quiz quiz = quizRepository.findQuizById(id);
        List<Integer> questionsIds = quiz.getQuestionsIds();
        List<QuestionDto> questions = quizInterface.getQuestions(questionsIds).getBody();
        return questions;
    }

    public int getScore(Integer id, List<Response> response) {
        int score = quizInterface.getScore(response).getBody();
        return score;
    }
}
