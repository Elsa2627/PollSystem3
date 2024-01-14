package com.yourcompany.pollservice.controller;

import com.yourcompany.pollservice.model.PollQuestion;
import com.yourcompany.pollservice.repository.PollQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollQuestionService {

    private final PollQuestionRepository pollQuestionRepository;

    @Autowired
    public PollQuestionService(PollQuestionRepository pollQuestionRepository) {
        this.pollQuestionRepository = pollQuestionRepository;
    }


    public List<PollQuestion> searchQuestionsByKeyword(String keyword) {
        return pollQuestionRepository.findByTitleContaining(keyword);
    }


}
