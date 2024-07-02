package com.microservice.quiz_service.Repository;
import com.microservice.quiz_service.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    Quiz findQuizById(int id);
}
