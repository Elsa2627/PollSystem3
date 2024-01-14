package com.yourcompany.pollservice.repository;

import com.yourcompany.pollservice.model.PollQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollQuestionRepository extends JpaRepository<PollQuestion, Long> {

    Optional<PollQuestion> findByTitle(String title);

    List<PollQuestion> findByTitleContaining(String keyword);



}
