package com.microservice.question_service.Service;
import com.microservice.question_service.Model.Question;
import com.microservice.question_service.Model.Response;
import com.microservice.question_service.Repository.QuestionRepository;
import com.microservice.question_service.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question addQuestion(Question req){
            return questionRepository.save(req);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(String topic) {
        return questionRepository.getQuestionByTopic(topic);
    }

    public List<Integer> getQuestions(String topic, Integer numQue) {
        List<Integer> questions = questionRepository.getRandomQuestionByTopic(topic,numQue);
        return questions;
    }

    public List<QuestionDto> getQuestionsById(List<Long> request) {
        List<QuestionDto> dtos = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(Long i : request){
            questions.add(questionRepository.findById(i).get());
        }
        for (Question que: questions){
            QuestionDto dto = new QuestionDto();
            dto.setQuestion(que.getQuestion());
            dto.setTopic(que.getTopic());
            dto.setOp1(que.getOp1());
            dto.setOp2(que.getOp2());
            dto.setOp3(que.getOp3());
            dto.setOp4(que.getOp4());
            dto.setQuestion(que.getQuestion());
            dto.setQId(que.getQId());
            dtos.add(dto);
        }
        return dtos;
    }


    public Integer getScore(List<Response> response) {
        Integer score = 0;
        for(Response res: response){
            Question ques = questionRepository.findById(res.getId()).get();
            if(res.getResponse().equals(ques.getCorrectAnswer()))
                score++;
        }
        return score;
    }
}
