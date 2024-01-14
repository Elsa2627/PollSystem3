package com.yourcompany.pollservice.service;

import com.yourcompany.pollservice.model.QuestionStatistics;
import com.yourcompany.pollservice.repository.PollResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    private final PollResponseRepository pollResponseRepository;

    @Autowired
    public StatisticsService(PollResponseRepository pollResponseRepository) {
        this.pollResponseRepository = pollResponseRepository;
    }
    
    public QuestionStatistics getStatisticsForQuestion(Long questionId) {
        List<Object[]> rawStats = pollResponseRepository.countTotalResponsesByOption(questionId);
        Map<String, Long> optionCounts = new HashMap<>();
        for (Object[] entry : rawStats) {
            optionCounts.put((String) entry[0], (Long)
                    entry[1]);
        }
        return new QuestionStatistics(questionId, optionCounts);


    }

}

