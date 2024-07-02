package com.microservice.question_service.Repository;
import com.microservice.question_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

  //@Query(value = "select * from question_datasource.question que where que.topic='Java'")
   List<Question> getQuestionByTopic(String topic);

   @Query(value = "SELECT q_id FROM question q Where q.topic = :topic ORDER BY RAND() LIMIT :numQue", nativeQuery = true)
    List<Integer> getRandomQuestionByTopic(String topic, int numQue);
}
