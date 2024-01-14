package com.yourcompany.pollservice.controller;

import com.yourcompany.pollservice.model.PollQuestion;
import com.yourcompany.pollservice.repository.PollQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollQuestionService {

    private final PollQuestionRepository pollQuestionRepository;

    @Autowired
    public PollQuestionService(PollQuestionRepository pollQuestionRepository) {
        this.pollQuestionRepository = pollQuestionRepository;
    }

    public Optional<PollQuestion> getQuestionByTitle(String title) {
        return pollQuestionRepository.findByTitle(title);
    }

    public List<PollQuestion> searchQuestionsByKeyword(String keyword) {
        return pollQuestionRepository.findByTitleContaining(keyword);
    }


}
