package com.microservice.question_service.Controller;
import com.microservice.question_service.Model.Question;
import com.microservice.question_service.Model.Response;
import com.microservice.question_service.Service.QuestionService;
import com.microservice.question_service.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class AddQuestions {

    @Autowired
    QuestionService questionService;

    @GetMapping("getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
    try{
        return new ResponseEntity<>(questionService.getAllQuestion(),HttpStatus.OK);
    }catch (Exception e){
       e.printStackTrace();;
    }
    return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("add")
    public ResponseEntity<Question>  addQuestion(@RequestBody Question question){
    return new  ResponseEntity(questionService.addQuestion(question), HttpStatus.OK) ;
    }

    @GetMapping("questionBycategory/{topic}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String topic){
        return new ResponseEntity(questionService.getQuestionByCategory(topic), HttpStatus.OK);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String topic, @RequestParam Integer numQue){
        List<Integer> qal = new ArrayList<>();
        qal = questionService.getQuestions(topic,numQue);
        return new ResponseEntity<>(qal, HttpStatus.OK);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionDto>> getQuestions(@RequestBody List<Long> request){
       List<QuestionDto> dto = new ArrayList<>();
        dto = questionService.getQuestionsById(request);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> res){
        Integer score = questionService.getScore(res);
        return new ResponseEntity<>(score,HttpStatus.OK);
    }

}

//engineer/cmt
